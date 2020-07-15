package com.lsy.mobile_store.dao;

import com.lsy.mobile_store.entity.BuyerAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author : 卢树雁
 * @Classname BuyerAddressDaoTest
 * @Description TODO
 * @Date 2020/07/15 17:26
 */
@SpringBootTest
class BuyerAddressDaoTest {
    @Autowired
    private BuyerAddressDao buyerAddressDao;

    @Test
    void test(){
        List<BuyerAddress> all = buyerAddressDao.findAll();
        for (BuyerAddress buyerAddress : all) {
            System.out.println(buyerAddress);
        }
    }
}