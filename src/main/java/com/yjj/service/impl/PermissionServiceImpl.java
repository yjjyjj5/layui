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
    public int deletePermissionByRoleId(Integer id) {
        return permissionMapper.deletePermissionByRoleId(id);
    }

    @Override
    public int batchInsertPermission(Map map) {
        return permissionMapper.batchInsertPermission(map);
    }

    @Override
    public List<Permission> list() {
        return permissionMapper.list();
    }

    @Override
    public List<Permission> listPage(Integer page, Integer limit) {
        return permissionMapper.listPage(page,limit);
    }

    @Override
    public int delete(Integer id) {
        return permissionMapper.delete(id);
    }

    @Override
    public int deleteParentid(Integer parentid) {
        return permissionMapper.deleteParentid(parentid);
    }

    @Override
    public Permission selectByParentid(Integer parentid) {
        return permissionMapper.selectByParentid(parentid);
    }

    @Override
    public List<Permission> selectByType(Integer type) {
        return permissionMapper.selectByType(type);
    }

    @Override
    public Permission selectById(Integer id) {
        return permissionMapper.selectById(id);
    }

    @Override
    public int insert(Permission permission) {
        return permissionMapper.insert(permission);
    }

    @Override
    public int update(Permission permission) {
        return permissionMapper.update(permission);
    }


}
