package com.yjj.shiro;

import com.yjj.entity.Permission;
import com.yjj.entity.Role;
import com.yjj.entity.User;
import com.yjj.service.PermissionService;
import com.yjj.service.RoleService;
import com.yjj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author
 * @date: 2021/2/22 16:30
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    /**
     * 认证方法
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //得到登录的令牌信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getOne(token.getUsername(),String.valueOf(token.getPassword()));
        if(user==null){
            throw new UnknownAccountException("用户名或密码错误");
        }else if(user.getStatus().equals("不可用")){
            throw new DisabledAccountException("账号不可用");
        }else{
            //修改最后登录时间
            //user.setLastlogintime(LocalDateTime.now());
            //userService.updateById(user);
            //查询当前登录用户拥有的角色，方便后面使用
            List<Role> roles=roleService.queryRolesByUserId(user.getId());
            user.setRoles(roles);
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
    /**
     * 授权方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info =new SimpleAuthorizationInfo();
        //查询当前登录用户的角色拥有的所有的操作权限
        User u = (User) SecurityUtils.getSubject().getPrincipal();
        List<Permission> list=permissionService.queryOperationPermissionByRoleId(u.getRoles());
        Set<String> set=new HashSet<String>();
        for (Permission p : list){
            set.add(p.getPerms());
        }
        //将所有的权限编码设置到授权对象中
        info.setStringPermissions(set);
        return info;
    }


}