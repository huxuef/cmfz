package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.LogDAO;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDAO logDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Log> queryAll() {
        return logDAO.findAll();
    }

    @Override
    public void addLog(Log log) {
        logDAO.insert(log);
    }
}
