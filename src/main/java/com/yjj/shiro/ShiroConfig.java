package com.yjj.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @date: 2021/2/22 16:29
 */
@Configuration
public class ShiroConfig {

    @Bean
    public MyShiroRealm shiroRealm(){
        return new MyShiroRealm();
    }

    @Bean
    public SessionsSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置登录界面
        shiroFilterFactoryBean.setLoginUrl("/");
        //设置登录成功后的跳转页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //设置未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/401");

        //创建map集合，用来存储哪些需要拦截，哪些不拦截
        Map<String,String> filterMap=new HashMap<String,String>();
        filterMap.put("/js/**","anon");
        filterMap.put("/image/**","anon");
        filterMap.put("/layui/**","anon");
        filterMap.put("/css/**","anon");
        //filterMap.put("/login.jsp","anon");
        filterMap.put("/user/login","anon");
        //logout过滤器用来完成退出操作，有shiro自动完成
        filterMap.put("/user/logout","logout");

        //所有资源全部过滤，需要放置到最后
        filterMap.put("/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}