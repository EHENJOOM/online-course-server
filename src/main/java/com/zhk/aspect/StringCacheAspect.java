package com.zhk.aspect;

import com.zhk.annotation.StringCache;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.lang.reflect.Parameter;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * StringCache注解实现类
 * @author 赵洪苛
 * @date 2020/8/5 17:29
 * @description StringCache注解实现类
 */
@Slf4j
@Aspect
@Component
public class StringCacheAspect {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("@annotation(com.zhk.annotation.StringCache)")
    public void annotationPointCut() { }

    @Around("annotationPointCut()")
    public Object cache(ProceedingJoinPoint joinPoint) {
        // 获取方法签名、StringCache注解、目标方法的实参、形参
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        StringCache stringCache = signature.getMethod().getAnnotation(StringCache.class);
        Parameter[] parameters = signature.getMethod().getParameters();
        Object[] args = joinPoint.getArgs();

        // 获取注解中的各项值
        String key = stringCache.key();
        String prefix = stringCache.prefix();
        long live = stringCache.live();
        TimeUnit timeunit = stringCache.timeunit();

        // 检验key是否合法
        if (StringUtils.isEmpty(key) || key.length() < 2) {
            throw new IllegalArgumentException("@StringCache注解中，key的值不能为空且key的长度必须大于2！");
        }
        // 检验prefix是否合法
        if (StringUtils.isEmpty(prefix)) {
            throw new IllegalArgumentException("@StringCache注解中，prefix的值不能为空！");
        }
        // 检验方法返回类型是否合法
        if (!signature.getReturnType().equals(String.class)) {
            throw new IllegalStateException("@StringCache注解标注的方法的返回值类型必须为String！");
        }

        // 如果key以#开头，则取其后面的部分为形参名，并找到对应的实参值
        if (key.startsWith("#")) {
            key = key.substring(1);
            for (int i = 0; i < parameters.length; i++) {
                if (Objects.equals(key, parameters[i].getName())) {
                    key = (String) args[i];
                }
            }
        }

        // 将key和prefix组成唯一主键，并查询缓存中是否有值，若有则直接返回，不执行目标方法
        key = prefix + "-" + key;
        String value = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(value)) {
            log.info("键({})在缓存中有值：{}", key, value);
            return value;
        }

        // 若缓存中没有值，则执行目标方法，并获取返回值，将返回值存入缓存中
        try {
            String result = (String) joinPoint.proceed();
            stringRedisTemplate.opsForValue().set(key, result, live, timeunit);
            log.info("键({})在缓存中没有值，但已将值{}存入缓存", key, result);
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }



}
