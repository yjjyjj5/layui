package com.yjj.util;

import com.yjj.controller.UserController;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author
 * @date: 2021/2/22 17:48
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionResolver.class);
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv;
        //进行一场判断，如果捕获异常请求跳转
        //未认证
        if(ex instanceof UnknownAccountException || ex instanceof DisabledAccountException) {
            mv = new ModelAndView("/login");
            ex.printStackTrace();
            mv.addObject("msg", ex.getMessage());
            log.debug(ex.toString()+"");
            return mv;
        }else if(ex instanceof UnauthorizedException || ex instanceof AuthorizationException){
            //未授权
            mv=new ModelAndView("/401");
            ex.printStackTrace();
            mv.addObject("msg","没有此权限!");
            log.debug(ex.toString()+"");
            return mv;
        }else{
            mv=new ModelAndView("/error");
            ex.printStackTrace();
            mv.addObject("msg","页面错误！");
            log.debug(ex.toString()+"");
            return mv;
        }
    }
}