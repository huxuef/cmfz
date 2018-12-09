package com.baizhi.cmfz.shiro;


import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Premission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private ManagerService managerService;
    /**
     * 获取授权信息的方法
     *    角色信息 + 权限信息
     *
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("--------------获取授权信息中！---------------");
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<Role> roles = managerService.queryRolesByName(username);
        List<Premission> premissions = managerService.queryPremissionByRole(username);
        if(!roles.isEmpty()){
            for (Role role : roles) {
                info.addRole(role.getName());
            }
        }
        if(!premissions.isEmpty()){
            for (Premission premission : premissions) {
                info.addStringPermission(premission.getName());
            }
        }
        return info;

    }

    /**
     * 获取认证信息的方法
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("--------------获取认证信息中！---------------");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String username = usernamePasswordToken.getUsername();
        Manager manager = managerService.queryOneByName(username);

        System.out.println("输入："+username);
        System.out.println("输入："+manager.getPassword());


        // 加密的凭证信息
        if (manager != null){
            return new SimpleAuthenticationInfo(manager.getName(),
                    manager.getPassword(),
                    ByteSource.Util.bytes(manager.getSolt()),
                    UUID.randomUUID().toString());
        }
        return null;
    }
}
