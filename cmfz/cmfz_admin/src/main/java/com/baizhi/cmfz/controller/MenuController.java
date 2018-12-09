package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MenuController {

    @Autowired
    private MenuService menuService;

    // 展示所有菜单
    @RequestMapping("/showAllMenu")
    public List<Menu> showAllMenu(){
        List<Menu> menus = menuService.queryAllMenu();
        return menus;
    }
}
