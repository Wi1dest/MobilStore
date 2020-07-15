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
 * @Author : 卢树雁
 * @Classname Specs
 * @Description 商品规格
 * @Date 2020/07/15 17:00
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Specs {
    /**
     * 规格ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specsId;

    /**
     * 商品ID
     */
    private String goodsId;

    /**
     * 规格名字
     */
    private String specsName;

    /**
     * 规格数量
     */
    private Integer specsStock;

    /**
     * 规格单价
     */
    private BigDecimal specsPrice;

    /**
     * 规格图片
     */
    private String specsIcon;

    /**
     * 规格预览图
     */
    private String specsPreview;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
