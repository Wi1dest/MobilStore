package com.lsy.mobile_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : 卢树雁
 * @Classname CategoryVo
 * @Description 类别VO
 * @Date 2020/07/15 20:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVo {
    /**
     * 类别名称
     */
    @JsonProperty("name")
    private String categoryName;

    /**
     * 类别编号
     */
    @JsonProperty("type")
    private Integer categoryType;
}
