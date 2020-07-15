package com.lsy.mobile_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author : Lo Shu-ngan
 * @Classname OrderDetailVO
 * @Description 订单详情
 * @Date 2020/07/16 02:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVO {
    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 买家名
     */
    private String buyerName;

    /**
     * 买家电话
     */
    @JsonProperty("tel")
    private String buyerPhone;

    /**
     * 买家地址
     */
    @JsonProperty("address")
    private String buyerAddress;

    /**
     * 商品数量
     */
    @JsonProperty("num")
    private Integer goodsQuantity;

    /**
     * 商品名字
     */
    private String goodsName;

    /**
     * 规格名称
     */
    @JsonProperty("specs")
    private String specsName;

    /**
     * 规格价格
     */
    @JsonProperty("price")
    private String specsPrice;

    /**
     * 商品图片
     */
    @JsonProperty("icon")
    private String goodsIcon;

    /**
     * 订单总价
     */
    @JsonProperty("amount")
    private BigDecimal orderAmount;

    /**
     * 订单支付状态
     */
    private Integer payStatus;

    /**
     * 运费
     */
    private Integer freight = 10;
}
