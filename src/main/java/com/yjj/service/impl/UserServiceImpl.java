package com.yjj.service.impl;

import com.yjj.controller.UserController;
import com.yjj.entity.User;
import com.yjj.mapper.UserMapper;
import com.yjj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @date: 2021/2/22 10:54
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 登录
     * @param user
     * @return
     */
    @Cacheable(value = {"login"})
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Cacheable(value = {"UsergetOne"})
    @Override
    public User getOne(String username,String password) {
        return userMapper.getOne(username,password);
    }

    @Cacheable(value = {"UserList"})
    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Cacheable(value = {"UserlistPage"})
    @Override
    public List<User> listPage(Integer page, Integer limit) {
        return userMapper.listPage(page,limit);
    }

    @CacheEvict(value = {"UserList","UserlistPage"},allEntries = true)
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public List<User> selectUserRole(Integer id) {
        return userMapper.selectUserRole(id);
    }

    @Override
    public int deleteUserRoleUserid(Integer id) {
        return userMapper.deleteUserRoleUserid(id);
    }

    @Override
    public int batchInsertPermission(Map map) {
        return userMapper.batchInsertPermission(map);
    }

}
