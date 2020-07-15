package com.lsy.mobile_store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Lo Shu-ngan
 * @Classname OrderDTO
 * @Description 订单DTO类
 * @Date 2020/07/16 01:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 规格编号
     */
    private Integer specsId;

    /**
     * 商品数量
     */
    private Integer goodsQuantity;
}
