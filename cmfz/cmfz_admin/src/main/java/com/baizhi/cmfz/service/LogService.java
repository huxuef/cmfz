package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;

import java.util.List;

public interface LogService {

    public List<Log> queryAll();

    public void addLog(Log log);
}
