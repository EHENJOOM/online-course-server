package com.zhk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author 赵洪苛
 * @date 2020/8/3 19:44
 * @description 允许跨域访问
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许任何域名访问
        corsConfiguration.addAllowedOrigin("*");
        // 允许任何请求头访问
        corsConfiguration.addAllowedHeader("*");
        // 允许任何方法访问
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

}
