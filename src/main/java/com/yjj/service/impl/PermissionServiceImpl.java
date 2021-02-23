package com.yjj.service.impl;

import com.yjj.entity.Permission;
import com.yjj.entity.Role;
import com.yjj.mapper.PermissionMapper;
import com.yjj.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @date: 2021/1/27 16:11
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Cacheable(value = {"queryMenuPermissionByRoleId"})
    @Override
    public List<Permission> queryMenuPermissionByRoleId(List<Role> roles) {
        return permissionMapper.queryMenuPermissionByRoleId(roles);
    }

    @Cacheable(value = {"queryOperationPermissionByRoleId"})
    @Override
    public List<Permission> queryOperationPermissionByRoleId(List<Role> roles) {
        return permissionMapper.queryOperationPermissionByRoleId(roles);
    }

    @Cacheable(value = {"queryOwenPermissionByRoleId"})
    @Override
    public List<Permission> queryOwenPermissionByRoleId(Integer rid) {
        return permissionMapper.queryOwenPermissionByRoleId(rid);
    }

    @CacheEvict(value = {"queryOwenPermissionByRoleId"},allEntries = true)
    @Override
    public int deletePermissionByRoleId(Integer rid) {
        return permissionMapper.deletePermissionByRoleId(rid);
    }

    @Override
    public int batchInsertPermission(Map map) {
        return permissionMapper.batchInsertPermission(map);
    }



}
