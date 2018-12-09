package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.ManagerDAO;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Premission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDAO managerDAO;


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Manager login(String name, String password) {
        Manager manager = managerDAO.findByName(name);
        if(manager!=null){
            if(!manager.getPassword().equals(password)){
                throw new RuntimeException("-------密码错误--------");
            }else{
                return manager;
            }
        }else {
            throw new RuntimeException("-------用户名不存在--------");
        }
    }

    @Override
    public Manager queryOneByName(String name) {
        return managerDAO.findByName(name);
    }

    @Override
    public List<Role> queryRolesByName(String name) {
        return managerDAO.findRolesByName(name);
    }

    @Override
    public List<Premission> queryPremissionByRole(String name) {
        return managerDAO.findPremissionByRole(name);
    }
}
