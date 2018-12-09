package com.baizhi.test;

import com.baizhi.cmfz.Application;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.service.MasterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class TestMaster {

    @Autowired
    private MasterService masterService;

    @Test
    public void testManagerLogin(){
        List<Master> masters = masterService.queryAll();
        for (Master master : masters) {
            System.out.println(master);
        }
    }
}
