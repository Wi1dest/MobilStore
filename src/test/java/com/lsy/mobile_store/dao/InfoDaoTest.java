package com.lsy.mobile_store.dao;

import com.lsy.mobile_store.entity.Info;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author : 卢树雁
 * @Classname InfoDaoTest
 * @Description TODO
 * @Date 2020/07/15 16:58
 */
@SpringBootTest
class InfoDaoTest {
    @Autowired
    private InfoDao infoDao;

    @Test
    void Test(){
        List<Info> all = infoDao.findAll();
        for (Info info : all) {
            System.out.println(info);
        }
    }
}