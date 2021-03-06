package com.zhk.aspect;

import com.zhk.annotation.PreventRepeatSubmit;
import com.zhk.config.Config;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author 赵洪苛
 * @date 2020/7/30 20:18
 * @description 防止接口重复提交，通过AOP切面实现
 */
@Slf4j
@Aspect
@Component
public class PreventRepeatSubmitAspect {

    @Resource
    private RedisTemplate<String, Integer> redisTemplate;

    @Pointcut("@annotation(com.zhk.annotation.PreventRepeatSubmit)")
    public void annotationPointCut() { }

    @Around("annotationPointCut()")
    public Object prevent(ProceedingJoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // TODO 在后续引入token后进行修改 String token = request.getParameter("token");
        String token = request.getParameter("token");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取标注的详细方法名，并将token拼接起来形成唯一key值
        String method = signature.getMethod().getName();
        String typeName = signature.getDeclaringTypeName();
        String key = token + "." + typeName + "." + method;

        // 获取标注在目标方法上的PreventRepeatSubmit注解中的数据
        PreventRepeatSubmit annotation = signature.getMethod().getAnnotation(PreventRepeatSubmit.class);
        int num = annotation.num();
        long interval = annotation.interval();
        TimeUnit timeUnit = annotation.timeunit();

        log.info("{}.{}访问，num：{}，interval：{} {}", typeName, method, num, interval, timeUnit);

        try {
            // 如果缓存中有key值，则判断剩余可访问次数，否则新建缓存
            if (redisTemplate.hasKey(key)) {
                // 获取剩余访问次数
                int lastNum = redisTemplate.opsForValue().get(key);
                // 可访问次数小于等于0，则拒绝访问
                if (lastNum <= 0) {
                    return ResultUtil.error(Config.INTERFACE_BUSY, "提交过于繁忙，请稍后再试！", token);
                } else {
                    // 修改课访问次数，并放行访问
                    redisTemplate.opsForValue().set(key, lastNum - 1, interval, timeUnit);
                    return joinPoint.proceed();
                }
            } else {
                // 新建缓存，将可访问次数减一，然后放行
                redisTemplate.opsForValue().set(key, num - 1, interval, timeUnit);
                return joinPoint.proceed();
            }
        } catch (Throwable throwable) {
            return ResultUtil.exception("服务器异常，请稍后再试！", null);
        }
    }

}
