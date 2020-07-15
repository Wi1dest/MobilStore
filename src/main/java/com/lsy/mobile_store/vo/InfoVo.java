package com.lsy.mobile_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Author : Lo Shu-ngan
 * @Classname InfoVo
 * @Description 商品Vo
 * @Date 2020/07/15 20:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoVo {
    /**
     * 商品ID
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * 商品名称
     */
    @JsonProperty("title")
    private String name;

    /**
     * 商品价格
     */
    @JsonProperty("price")
    private BigDecimal price;

    /**
     * 商品介绍
     */
    @JsonProperty("desc")
    private String description;

    /**
     * 标签
     */
    @JsonProperty("tag")
    private List<Map<String,String>> tag;

    /**
     * 商品图片
     */
    @JsonProperty("thumb")
    private String icon;
}
