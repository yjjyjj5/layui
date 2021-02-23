package com.yjj.service;

import com.yjj.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @date: 2021/2/22 10:54
 */
public interface UserService {

    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public User getOne(String username,String password);

    /**
     * 查询全部
     * @return
     */
    public List<User> list();

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    public List<User> listPage(Integer page,Integer limit);

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int insert(User user);

    /**
     * 根据ID进行查询
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 根据ID进行修改
     * @param user
     * @return
     */
    public int update(User user);

    /**
     * 根据ID进行删除
     * @param id
     * @return
     */
    public int delete(Integer id);
}
