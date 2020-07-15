package com.lsy.mobile_store.dao;

import com.lsy.mobile_store.entity.Specs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author : 卢树雁
 * @Classname SpecsDaoTest
 * @Description TODO
 * @Date 2020/07/15 17:06
 */
@SpringBootTest
class SpecsDaoTest {
    @Autowired
    private SpecsDao specsDao;

    @Test
    void test(){
        List<Specs> all = specsDao.findAll();
        for (Specs specs : all) {
            System.out.println(specs);
        }
    }
}