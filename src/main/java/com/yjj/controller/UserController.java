package com.yjj.controller;

import com.yjj.entity.Dtree;
import com.yjj.entity.Role;
import com.yjj.entity.User;
import com.yjj.service.RoleService;
import com.yjj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 用户
 * @author
 * @date: 2021/2/22 10:55
 */
@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
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
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @RequiresPermissions("user:delete")
    @ResponseBody
    public String delete(Integer id){
        System.out.println("UserController.delete");
        userService.delete(id);
        return "success";
    }


    /**
     * 查询当前用户所拥有的权限
     * @param id
     * @return
     */
    @RequestMapping(value = "userRoleS",method = RequestMethod.POST)
    @RequiresPermissions("user:update")
    @ResponseBody
    public Map userRoleS(Integer id){
        System.out.println("UserController.userRoleS");
        //查所有权限
        List<Role> roleList= roleService.list();
        List list=new ArrayList();
        for (Role p:roleList){
            Dtree d=new Dtree(p.getId(),p.getName(),"0",0);
            list.add(d);
        }
        Map map=new HashMap();
        Map map2=new HashMap();
        //查当前操作的角色拥有的权限
        List<User> userList=userService.selectUserRole(id);
        if(userList.size()!=0){
            StringBuffer str=new StringBuffer();
            for (int i=0;i<userList.size();i++){
                str.append(userList.get(i).getId()+",");
            }
            String st=str.substring(0,str.lastIndexOf(","));
            System.out.println(st);
            map2.put("count",st);
        }
        map.put("status",map2);
        map2.put("code",200);
        map2.put("message","操作成功");
        map.put("data",list);
        System.out.println(map.toString());
        return map;
    }

    /**
     * 授予新角色
     * @param choose
     * @param id
     * @return
     */
    @RequestMapping(value = "dispatch",method = RequestMethod.POST)
    @RequiresPermissions("role:update")
    @ResponseBody
    public String dispatch(Integer[] choose,Integer id){
        System.out.println("UserController.dispatch");
        System.out.println(Arrays.toString(choose) +"---"+id);
        userService.deleteUserRoleUserid(id);
        Map map=new HashMap();
        map.put("id",id);
        map.put("perArr",choose);
        userService.batchInsertPermission(map);
        return "success";
    }
}
