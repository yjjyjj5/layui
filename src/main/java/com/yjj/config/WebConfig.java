package com.yjj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author
 * @date: 2021/2/22 10:57
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 进入登录
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        //registry.addViewController("/index").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/401").setViewName("401");
        registry.addViewController("/error").setViewName("error");
    }
}
