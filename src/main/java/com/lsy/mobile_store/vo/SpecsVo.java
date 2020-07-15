package com.lsy.mobile_store.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Author : Lo Shu-ngan
 * @Classname SpecsVo
 * @Description 商品规格Vo
 * @Date 2020/07/15 21:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecsVo {
    /**
     * 商品
     */
    private Map<String,String> goods;

    /**
     * 商品规格
     */
    private SkuVo skuVo;
}
