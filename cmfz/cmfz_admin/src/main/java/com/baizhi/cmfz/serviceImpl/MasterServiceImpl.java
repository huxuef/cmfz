package com.baizhi.cmfz.serviceImpl;

import com.baizhi.cmfz.dao.MasterDAO;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterDAO masterDAO;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Master> queryAll() {
        return masterDAO.findAll();
    }
}
