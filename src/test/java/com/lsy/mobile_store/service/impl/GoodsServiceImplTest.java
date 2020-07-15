package com.lsy.mobile_store.service.impl;

import com.lsy.mobile_store.vo.DataVo;
import com.lsy.mobile_store.vo.InfoVo;
import com.lsy.mobile_store.vo.SpecsVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author : Lo Shu-ngan
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

    @Test
    void findInfoByCategoryType() {
        List<InfoVo> infoByCategoryType = goodsService.findInfoByCategoryType(1);
        System.out.println(infoByCategoryType);
    }

    @Test
    void findSpecsByGoodsId() {
        SpecsVo specsByGoodsId = goodsService.findSpecsByGoodsId(1);
        System.out.println(specsByGoodsId);
    }

}