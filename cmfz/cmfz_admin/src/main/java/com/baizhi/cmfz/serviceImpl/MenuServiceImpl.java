package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.MenuDAO;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDAO menuDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Menu> queryAllMenu() {
        return menuDAO.findAll();
    }
}
