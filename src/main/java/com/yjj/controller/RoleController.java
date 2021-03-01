package com.yjj.controller;

import com.yjj.entity.Dtree;
import com.yjj.entity.Permission;
import com.yjj.entity.Role;
import com.yjj.service.PermissionService;
import com.yjj.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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
    @Autowired
    private PermissionService permissionService;
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

    /**
     * 查看角色拥有的权限
     * @param id
     * @return
     */
    @RequestMapping("rolePermissionS")
    @RequiresPermissions("role:update")
    @ResponseBody
    public Map rolePermissionS(Integer id){
        System.out.println("UserController.rolePermissionS");
        //查所有权限
        List<Permission> permissionList=permissionService.list();
        List list=new ArrayList();
        for (Permission p:permissionList){
            Dtree d=new Dtree(p.getId(),p.getName(),"0",p.getParentid()==null?0:p.getParentid());
            list.add(d);
        }
        Map map=new HashMap();
        Map map2=new HashMap();
        //查当前操作的角色拥有的权限
        List<Permission> owenPermissionList=permissionService.queryOwenPermissionByRoleId(id);
        if(owenPermissionList.size()!=0){
            StringBuffer str=new StringBuffer();
            for (int i=0;i<owenPermissionList.size();i++){
                str.append(owenPermissionList.get(i).getId()+",");
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
     * 修改角色所拥有的权限
     * @param choose
     * @param id
     * @return
     */
    @RequestMapping("dispatch")
    @RequiresPermissions("role:update")
    public String dispatch(Integer[] choose,Integer id){
        System.out.println("UserController.dispatch");
        System.out.println(Arrays.toString(choose) +"---"+id);
        permissionService.deletePermissionByRoleId(id);
        Map map=new HashMap();
        map.put("id",id);
        map.put("perArr",choose);
        permissionService.batchInsertPermission(map);
        return "redirect:/role/list";
    }
}
