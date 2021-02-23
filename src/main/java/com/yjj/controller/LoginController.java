package com.yjj.controller;

import com.yjj.entity.User;
import com.yjj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author
 * @date: 2021/2/22 11:06
 */
@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @param model
     * @param session
     * @param attributes
     * @return
     */
    @RequestMapping("login")
    public String login(User user, Model model, HttpSession session, RedirectAttributes attributes){
        System.out.println("LoginController.login");
        User u = userService.login(user);
        if(u!=null){
            System.out.println(u.toString());
            session.setAttribute("user",user);
            log.info("------登录成功------");
            return "index";
        }else{
            attributes.addFlashAttribute("error","账号或密码错误");
            log.error("------账号或密码错误------");
            return "redirect:/";
        }
    }

    /**
     * 退出
     * @param session
     * @return
     */
//    @RequestMapping("logout")
//    public String logout(HttpSession session){
//        session.removeAttribute("user");
//        log.info("------退出登录------");
//        return "redirect:/";
//    }
}
