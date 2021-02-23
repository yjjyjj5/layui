package com.yjj.mapper;

import com.yjj.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author
 * @date: 2021/1/27 16:18
 */
@Mapper
public interface RoleMapper {


    public List<Role> queryRolesByUserId(Integer uid);


}
