package com.lsy.mobile_store.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author : Lo Shu-ngan
 * @Classname TreeVo
 * @Description 商品 sku 数据 Tree
 * @Date 2020/07/15 21:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeVo {
    /**
     * 规格类目名称
     */
    private String k = "规格";

    /**
     * 商品规格信息
     */
    private List<GoodsSpecsVo> v;

    /**
     * sku 组合列表（下方 list）中当前类目对应的 key 值，value 值会是从属于当前类目的一个规格值 id
     */
    private String k_s = "s1";
}
