package com.lsy.mobile_store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author : Lo Shu-ngan
 * @Classname Info
 * @Description 商品信息
 * @Date 2020/07/15 16:52
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    /**
     * 商品ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品介绍
     */
    private String description;

    /**
     * 商品库存
     */
    private Integer stock;

    /**
     * 商品图片
     */
    private String icon;

    /**
     * 商品类别编号
     */
    private Integer categoryType;

    /**
     * 商品标签
     */
    private String tag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
