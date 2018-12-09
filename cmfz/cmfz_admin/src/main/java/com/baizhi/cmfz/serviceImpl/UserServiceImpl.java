package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.UserDAO;
import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.entity.UserLocation;
import com.baizhi.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    // 查所有
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> queryAll() {
        return userDAO.findAll();
    }

    // 增
    @Override
    public void addUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userDAO.insert(user);
    }

    // 自定义查询
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> queryCondition(String queryCondition) {
        return userDAO.findCondition(queryCondition);
    }

    // 统计分析
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Integer queryCount(Integer days) {
        return userDAO.findCount(days);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UserLocation> queryLocationCount(String sex) {
        return userDAO.findLocationCount(sex);
    }
}
