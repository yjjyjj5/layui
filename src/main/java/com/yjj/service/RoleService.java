package com.yjj.service;

import com.yjj.entity.Role;

import java.util.List;

/**
 * @author
 * @date: 2021/1/27 16:16
 */
public interface RoleService {

    public List<Role> queryRolesByUserId(Integer uid);


}
