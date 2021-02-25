package com.yjj.controller;

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
}
