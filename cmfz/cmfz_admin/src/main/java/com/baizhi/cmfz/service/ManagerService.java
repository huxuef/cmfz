package com.baizhi.cmfz.service;


import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Premission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

public interface ManagerService {

    // 登陆=====name和password
    public Manager login(String name, String password);

    // 登陆=====name和password
    public Manager queryOneByName(String name);

    // 查询用户角色
    public List<Role> queryRolesByName(String name);

    //查询用户权限
    public List<Premission> queryPremissionByRole(String name);
}
