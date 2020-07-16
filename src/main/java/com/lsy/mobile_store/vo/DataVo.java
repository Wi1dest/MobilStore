package com.lsy.mobile_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author : Lo Shu-ngan
 * @Classname DataVo
 * @Description 数据VO
 * @Date 2020/07/15 20:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataVo {
    /**
     * 类别集合
     */
    @JsonProperty("categories")
    List<CategoryVo> categoryList;

    /**
     * 商品信息集合
     */
    @JsonProperty("goodsList")
    List<InfoVo> infoList;
}
