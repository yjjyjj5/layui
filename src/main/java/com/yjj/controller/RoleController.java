package com.yjj.controller;

import com.yjj.service.RoleService;
import com.yjj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 角色
 * @author
 * @date: 2021/2/23 18:32
 */
@Controller
@RequestMapping("user")
public class RoleController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;
    Map<String, Object> map = new HashMap<String, Object>();


}
