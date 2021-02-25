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

    /**
     * 添加角色
     * @param role
     * @return
     */
    public int insert(Role role);

    /**
     * 根据ID进行删除
     * @param id
     * @return
     */
    public int delete(Integer id);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public Role selectById(Integer id);

    /**
     * 根据ID进行修改
     * @param role
     * @return
     */
    public int update(Role role);
}
