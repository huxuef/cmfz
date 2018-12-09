package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.dao.LogDAO;
import com.baizhi.cmfz.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogDAO logDAO;

    @RequestMapping("/showAllLog")
    public List<Log> showAllLog(){
        List<Log> logs = logDAO.findAll();
        return logs;
    }
}
