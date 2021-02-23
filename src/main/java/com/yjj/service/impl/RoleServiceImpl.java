package com.yjj.service.impl;

import com.yjj.entity.Role;
import com.yjj.mapper.RoleMapper;
import com.yjj.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date: 2021/1/27 17:25
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Cacheable(value = {"queryRolesByUserId"})
    @Override
    public List<Role> queryRolesByUserId(Integer uid) {
        return roleMapper.queryRolesByUserId(uid);
    }


}