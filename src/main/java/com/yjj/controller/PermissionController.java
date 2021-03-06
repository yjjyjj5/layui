package com.yjj.controller;

import com.yjj.entity.Permission;
import com.yjj.service.PermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @date: 2021/2/25 14:38
 */
@Controller
@RequestMapping("permission")
public class PermissionController {
    private static final Logger log = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private PermissionService permissionService;
    Map<String, Object> map = new HashMap<String, Object>();

    /**
     * 分页查询权限信息
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "list1",method = RequestMethod.GET)
    @RequiresPermissions("permission:select")
    @ResponseBody
    public Map<String,Object> list1(Integer page, Integer limit){
        System.out.println("PermissionController.list1");
        map.put("data",permissionService.listPage((page-1)*limit,limit));
        map.put("code",0);
        map.put("msg","success");
        map.put("count",permissionService.list().size());
        return map;
    }

    /**
     * 根据类型查询id和name
     * @param type
     * @return
     */
    @RequestMapping(value = "selectByType",method = RequestMethod.POST)
    @RequiresPermissions("permission:insert")
    @ResponseBody
    public List<Permission> selectBytype(Integer type){
        System.out.println("PermissionController.selectBytype");
        return permissionService.selectByType(type);
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value = "selectById",method = RequestMethod.POST)
    @RequiresPermissions("permission:insert")
    @ResponseBody
    public Permission selectById(Integer id){
        System.out.println("PermissionController.selectById");
        return permissionService.selectById(id);
    }

    /**
     * 权限添加
     * @param permission
     * @return
     */
    @RequestMapping("insert")
    @RequiresPermissions("permission:insert")
    @ResponseBody
    public String insert(Permission permission){
        System.out.println("PermissionController.insert");
        if(permission.getType()==0){
            permissionService.insert(permission);
        }else if(permission.getType()==1){
            permissionService.insert(permission);
        }else{
            permissionService.insert(permission);
        }
        return "success";
    }

    /**
     * 删除权限
     * 如果是目录，则需要把目录、菜单和按钮删除
     * 如果是菜单，则需要把菜单和按钮删除
     * 如果是按钮，则需要把按钮删除
     * @param id
     * @return
     */
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @RequiresPermissions("permission:delete")
    @ResponseBody
    public String delete(Integer id){
        System.out.println("PermissionController.delete");
        Permission p = permissionService.selectById(id);
        if(p.getType()==0){
            if(p.getParentid()!=null){
                Permission p1 = permissionService.selectByParentid(p.getId());
                permissionService.deleteParentid(p1.getId());
                permissionService.delete(p1.getId());
            }
            permissionService.delete(id);
        }else if (p.getType()==1){
            permissionService.deleteParentid(id);
            permissionService.delete(id);
        }else{
            permissionService.delete(id);
        }
        return "success";
    }

    /**
     * 修改权限
     * @param permission
     * @return
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @RequiresPermissions("permission:update")
    @ResponseBody
    public String update(Permission permission){
        permissionService.update(permission);
        return "success";
    }
}
