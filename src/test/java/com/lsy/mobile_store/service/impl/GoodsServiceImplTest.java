package com.lsy.mobile_store.service.impl;

import com.lsy.mobile_store.vo.DataVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author : 卢树雁
 * @Classname GoodsServiceImplTest
 * @Description TODO
 * @Date 2020/07/15 20:46
 */
@SpringBootTest
class GoodsServiceImplTest {
    @Autowired
    private GoodsServiceImpl goodsService;

    @Test
    void findDataVo() {
        DataVo dataVo = goodsService.findDataVo();
        System.out.println(dataVo);
    }
}