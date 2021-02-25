package com.yjj.controller;

import com.yjj.entity.Role;
import com.yjj.service.RoleService;
import com.yjj.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 角色
 * @author
 * @date: 2021/2/23 18:32
 */
@Controller
@RequestMapping("role")
public class RoleController {
    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;
    Map<String, Object> map = new HashMap<String, Object>();

    /**
     * 分页查询角色信息
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "list1",method = RequestMethod.GET)
    @RequiresPermissions("role:select")
    @ResponseBody
    public Map<String,Object> list1(Integer page, Integer limit){
        System.out.println("RoleController.list1");
        map.put("data",roleService.listPage((page-1)*limit,limit));
        map.put("code",0);
        map.put("msg","success");
        map.put("count",roleService.list().size());
        return map;
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping(value = "insert",method = RequestMethod.POST)
    @RequiresPermissions("role:insert")
    @ResponseBody
    public String insert(Role role){
        System.out.println("RoleController.insert");
        roleService.insert(role);
        return "success";
    }

    /**
     * 根据ID进行删除
     * @param id
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @RequiresPermissions("role:delete")
    @ResponseBody
    public String delete(Integer id){
        System.out.println("RoleController.delete");
        roleService.delete(id);
        return "success";
    }

    /**
     * 根据ID进行用户查询
     * @param id
     * @return
     */
    @RequestMapping(value = "selectById",method = RequestMethod.POST)
    @RequiresPermissions("role:update")
    @ResponseBody
    public Role selectById(Integer id){
        System.out.println("RoleController.selectById");
        return roleService.selectById(id);
    }

    /**
     * 根据ID进行修改
     * @param role
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @RequiresPermissions("role:update")
    @ResponseBody
    public String update(Role role){
        System.out.println("UserController.update");
        roleService.update(role);
        return "success";
    }
}
