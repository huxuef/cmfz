package com.baizhi.test;

import com.baizhi.cmfz.Application;
import com.baizhi.cmfz.dao.UserDAO;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.entity.UserLocation;
import com.baizhi.cmfz.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestUser {

    @Autowired
    private UserService userService;

    @Test
    public void testQueryAll(){
        List<User> users = userService.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testAddUser(){
        User user = new User(null,"2","2","1","afa",
                "5454","l","21","1","2","2",new java.util.Date(),new java.util.Date());
        userService.addUser(user);

    }

    @Test
    public void testQuery(){
        List<User> users = userService.queryCondition("id,name");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryCount(){
        Integer integer = userService.queryCount(10);
        System.out.println(integer);
    }

    @Test
    public void testQueryLocation(){
        List<UserLocation> userLocation = userService.queryLocationCount("女");
        for (UserLocation location : userLocation) {
            System.out.println(location);
        }

    }
}
