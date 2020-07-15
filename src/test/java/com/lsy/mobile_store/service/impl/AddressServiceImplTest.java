package com.lsy.mobile_store.service.impl;

import com.lsy.mobile_store.vo.AddressVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author : Lo Shu-ngan
 * @Classname AddressServiceImplTest
 * @Description TODO
 * @Date 2020/07/15 23:14
 */
@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressServiceImpl addressService;

    @Test
    void findAllAddress() {
        List<AddressVO> allAddress = addressService.findAllAddress();
        for (AddressVO address : allAddress) {
            System.out.println(address);
        }
    }
}