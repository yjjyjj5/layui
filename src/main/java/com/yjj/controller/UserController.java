package com.yjj.controller;

import com.yjj.entity.User;
import com.yjj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @date: 2021/2/22 10:55
 */
@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    Map<String, Object> map = new HashMap<String, Object>();

    /**
     * 登录方法，跳转到index方法去
     * @param user
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(User user){
        System.out.println("UserController.login");
        //将用户名和密码封装成令牌
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        //指定shiro的登录操作
        subject.login(token);
        User u=(User)subject.getPrincipal();
        //将登录的用户信息存入session，方便取值
        subject.getSession().setAttribute("loginUser",u);
        log.info("------进入index方法------");
        return "redirect:/index";
    }

    /**
     * 退出方法，返回到登录页面
     * @param resp
     * @throws IOException
     */
    @RequestMapping("logout")
    public String logout(HttpServletResponse resp) throws IOException {
        System.out.println("UserController.logout");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        log.info("------退出登录------");
        return "redirect:/";
    }

    /**
     * 分页查询用户信息
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "list1",method = RequestMethod.GET)
    @RequiresPermissions("user:select")
    @ResponseBody
    public Map<String,Object> list1(Integer page, Integer limit){
        System.out.println("UserController.list1");
        map.put("data",userService.listPage((page-1)*limit,limit));
        map.put("code",0);
        map.put("msg","success");
        map.put("count",userService.list().size());
        return map;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    @RequiresPermissions("user:insert")
    @ResponseBody
    public String insert(User user){
        System.out.println("UserController.insert");
        userService.insert(user);
        return "success";
    }

    /**
     * 根据ID进行用户查询
     * @param id
     * @return
     */
    @RequestMapping(value = "selectById",method = RequestMethod.POST)
    @RequiresPermissions("user:update")
    @ResponseBody
    public User selectById(Integer id){
        System.out.println("UserController.selectById");
        return userService.selectById(id);
    }

    /**
     * 根据ID进行修改
     * @param user
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @RequiresPermissions("user:update")
    @ResponseBody
    public String update(User user){
        System.out.println("UserController.update");
        userService.update(user);
        return "success";
    }

    /**
     * 根据ID进行删除
     * @param id
     * @return
     */
    @RequestMapping(value = "delete")
    @RequiresPermissions("user:delete")
    @ResponseBody
    public String delete(Integer id){
        System.out.println("UserController.delete");
        userService.delete(id);
        return "success";
    }
}