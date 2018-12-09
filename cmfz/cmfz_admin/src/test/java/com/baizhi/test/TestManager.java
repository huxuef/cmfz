package com.baizhi.test;

import com.baizhi.cmfz.Application;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Premission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.ManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestManager {

    @Autowired
    private ManagerService managerService;

    @Test
    public void testManagerLogin(){
        Manager manager = managerService.login("tom", "123456");
        System.out.println(manager);
    }

    @Test
    public void testRole(){
        List<Role> tom = managerService.queryRolesByName("tom");
        for (Role role : tom) {
            System.out.println(role);
        }
    }

    @Test
    public void testPremission(){
        List<Premission> tom = managerService.queryPremissionByRole("tom");
        for (Premission premission : tom) {
            System.out.println(premission);
        }
    }
}
