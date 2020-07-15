package com.lsy.mobile_store.dao;

import com.lsy.mobile_store.entity.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author : Lo Shu-ngan
 * @Classname OrderMasterDaoTest
 * @Description TODO
 * @Date 2020/07/15 17:21
 */
@SpringBootTest
class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Test
    void test(){
        List<OrderMaster> all = orderMasterDao.findAll();
        for (OrderMaster orderMaster : all) {
            System.out.println(orderMaster);
        }
    }
}