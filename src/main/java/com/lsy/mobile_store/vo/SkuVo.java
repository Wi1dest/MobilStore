package com.lsy.mobile_store.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author : Lo Shu-ngan
 * @Classname SkuVo
 * @Description 商品规格Vo
 * @Date 2020/07/15 21:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkuVo {
    /**
     * 商品规格树
     */
    private List<TreeVo> tree;

    /**
     * 商品规格信息
     */
    private List<GoodsSpecsCasVO> list;

    /**
     * 商品价格
     */
    private String price;

    /**
     * 商品库存
     */
    private Integer stock_num;

    /**
     * 是否无规格商品
     */
    private Boolean none_sku = false;

    /**
     * 是否隐藏剩余库存
     */
    private Boolean hide_stock = false;
}
