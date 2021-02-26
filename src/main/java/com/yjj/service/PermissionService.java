package com.yjj.service;

import com.yjj.entity.Permission;
import com.yjj.entity.Role;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @date: 2021/1/27 16:11
 */
public interface PermissionService {
    public List<Permission> queryMenuPermissionByRoleId(List<Role> roles);

    public List<Permission> queryOperationPermissionByRoleId(List<Role> roles);

    public List<Permission> queryOwenPermissionByRoleId(Integer rid);

    public int deletePermissionByRoleId(Integer rid);

    public int batchInsertPermission(Map map);

    /**
     * 查询全部
     * @return
     */
    public List<Permission> list();

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    public List<Permission> listPage(Integer page,Integer limit);

    /**
     * 根据ID进行删除
     * @param id
     * @return
     */
    public int delete(Integer id);

    /**
     * 根据类型查询
     * @param type
     * @return
     */
    public List<Permission> selectByType(Integer type);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public Permission selectById(Integer id);

    /**
     * 添加权限
     * @param permission
     * @return
     */
    public int insert(Permission permission);

}
