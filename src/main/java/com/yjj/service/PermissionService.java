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


}
