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

    @Override
    public List<Role> list() {
        return roleMapper.list();
    }

    @Override
    public List<Role> listPage(Integer page, Integer limit) {
        return roleMapper.listPage(page,limit);
    }

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int delete(Integer id) {
        return roleMapper.delete(id);
    }

    @Override
    public Role selectById(Integer id) {
        return roleMapper.selectById(id);
    }

    @Override
    public int update(Role role) {
        return roleMapper.update(role);
    }


}
