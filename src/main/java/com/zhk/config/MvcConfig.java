package com.zhk.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 对Spring Mvc的一些配置
 * @author 赵洪苛
 * @date 2020/8/4 18:42
 * @description 对Spring Mvc的一些配置
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 将LoginHandlerInterceptor加入ioc容器中管理，否则拦截器中的服务将无法注入
     * @return
     */
    @Bean
    public LoginHandlerInterceptor loginHandlerInterceptor() {
        return new LoginHandlerInterceptor();
    }

    /**
     * 将自定义的Filter加入到容器中
     * @return
     */
    //@Bean
    public FilterRegistrationBean<BodyReaderFilter> filters() {
        FilterRegistrationBean<BodyReaderFilter> registrationBean = new FilterRegistrationBean<BodyReaderFilter>();
        registrationBean.setFilter(new BodyReaderFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("koalaSignFilter");
        return registrationBean;
    }


    /**
     * 注册拦截器，除了/login请求不拦截，其余资源均拦截
     * @param registry 拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/test")
                .excludePathPatterns("/login");
    }
}
