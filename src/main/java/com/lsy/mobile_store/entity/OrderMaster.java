package com.lsy.mobile_store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author : Lo Shu-ngan
 * @Classname OrderMaster
 * @Description 订单
 * @Date 2020/07/15 17:10
 */
@Data
@Entity
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class OrderMaster {
    /**
     * 订单ID
     */
    @Id
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
     * 商品ID
     */
    private Integer goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsQuantity;

    /**
     * 商品图片
     */
    private String goodsIcon;

    /**
     * 规格编号
     */
    private Integer specsId;

    /**
     * 规格名称
     */
    private String specsName;

    /**
     * 规格单价
     */
    private BigDecimal specsPrice;

    /**
     * 订单总价
     */
    private BigDecimal orderAmount;

    /**
     * 支付状态
     */
    private Integer payStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
