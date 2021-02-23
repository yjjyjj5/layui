package com.yjj.controller;

import com.yjj.entity.Permission;
import com.yjj.entity.User;
import com.yjj.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 页面跳转的
 * @author
 * @date: 2021/2/22 16:36
 */
@Controller
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private PermissionService permissionService;

    /**
     * 登录，进入index.jsp页面
     * @return
     */
    @RequestMapping("index")
    public String index(){
        System.out.println("IndexController.index");
        Subject subject = SecurityUtils.getSubject();
        //获取登录的用户信息
        User u=(User)subject.getPrincipal();
        //将登录的用户信息存入session，方便取值
        subject.getSession().setAttribute("user",u);
        //根据角色名查询菜单权限
        List<Permission> permissionList=permissionService.queryMenuPermissionByRoleId(u.getRoles());
        subject.getSession().setAttribute("permissionList",permissionList);
        log.info("------登录成功------");
        return "index";
    }

    /**
     * 进入用户页面
     * @return
     */
    @RequestMapping("user/list")
    @RequiresPermissions("user:select")
    public String userList(){
        System.out.println("IndexController.list");
        return "userList";
    }

    /**
     * 进入添加用户页面
     * @return
     */
    @RequestMapping("user/add")
    @RequiresPermissions("user:insert")
    public String userInsert(){
        System.out.println("IndexController.userInsert");
        return "userInsert";
    }

    /**
     * 进入编辑用户页面
     * 同时传入一个用户的id
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("user/edit")
    @RequiresPermissions("user:update")
    public String userEdit(Integer id, Model model){
        System.out.println("IndexController.userEdit");
        System.out.println(id);
        model.addAttribute("id",id);
        return "userEdit";
    }

    /**
     * 进入角色页面
     * @return
     */
    @RequestMapping("role/list")
    @RequiresPermissions("role:select")
    public String roleList(){
        System.out.println("IndexController.roleList");
        return "roleList";
    }
}