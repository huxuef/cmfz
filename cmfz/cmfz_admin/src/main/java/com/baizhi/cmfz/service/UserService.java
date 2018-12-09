package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.entity.UserLocation;

import java.util.List;

public interface UserService {

    // 查所有
    public List<User> queryAll();

    // 增
    public void addUser(User user);

    // 根据条件查询，下载需要的字段
    List<User> queryCondition(String queryCondition);

    // 查用户最后登录时间,统计分析
    Integer queryCount(Integer days);

    // 各个地区人数
    List<UserLocation> queryLocationCount(String sex);

}
