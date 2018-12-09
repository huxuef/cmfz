package com.baizhi.cmfz.dao;


import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Premission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

public interface ManagerDAO extends BaseDAO<Manager> {

    //查询用户角色
    public List<Role> findRolesByName(String name);

    //查询用户权限
    public List<Premission> findPremissionByRole(String name);
}
