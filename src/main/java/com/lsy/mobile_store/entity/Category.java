package com.lsy.mobile_store.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author : Lo Shu-ngan
 * @Classname Category
 * @Description 类别
 * @Date 2020/07/15 16:39
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    /**
     * 类别ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /**
     * 类别名称
     */
    private String categoryName;

    /**
     * 类别编号
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
