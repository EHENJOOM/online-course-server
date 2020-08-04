package com.zhk.config;

import cn.hutool.json.JSONUtil;
import com.zhk.service.TokenService;
import com.zhk.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author 赵洪苛
 * @date 2020/8/4 18:33
 * @description 登录状态检查
 */
@Slf4j
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Resource
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String number = request.getParameter("number");
        String token = request.getParameter("token");
        // 如果number、token参数没有值，则直接拒绝访问
        if (StringUtils.isEmpty(number) || StringUtils.isEmpty(token)) {
            returnJson(response, number);
            return false;
        }
        if (tokenService.verify(number, token)) {
            log.info("用户：{}授权成功", number);
            return true;
        }
        returnJson(response, number);
        return false;
    }

    /**
     * 给前端返回未授权消息
     * @param response HttpServletResponse
     */
    private void returnJson(HttpServletResponse response, String number) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(JSONUtil.toJsonStr(ResultUtil.error(Config.NOT_AUTHORIZE, "未授权的访问")));
            log.info("用户拦截成功：{}", number);
        } catch (Exception e) {
            log.error("授权拦截器异常：{}", e.getMessage());
            e.printStackTrace();
        }
    }
}
