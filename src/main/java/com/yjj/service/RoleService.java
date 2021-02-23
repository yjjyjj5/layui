package com.yjj.service;

import com.yjj.entity.Role;

import java.util.List;

/**
 * @author
 * @date: 2021/1/27 16:16
 */
public interface RoleService {

    public List<Role> queryRolesByUserId(Integer uid);

    /**
     * 查询全部
     * @return
     */
    public List<Role> list();

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    public List<Role> listPage(Integer page,Integer limit);
}
