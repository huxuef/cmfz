package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/master")
public class MasterController {

    @Autowired
    private MasterService masterService;

    // 展示上师信息
    @RequestMapping("/showAllMaster")
    public List<Master> showAllMaster(Model model){
        List<Master> masters = masterService.queryAll();
        model.addAttribute("master",masters);
        return masters;
    }
}
