package com.baizhi.test;

import com.baizhi.cmfz.Application;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestMenu {

    @Autowired
    private MenuService menuService;

    @Test
    public void testqueryAll(){
        List<Menu> menus = menuService.queryAllMenu();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }
}
