package com.lsy.mobile_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Lo Shu-ngan
 * @Classname GoodsSpecsVo
 * @Description 商品规格Vo
 * @Date 2020/07/15 21:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSpecsVo {
    /**
     * 规格值 id
     */
    @JsonProperty("id")
    private Integer specsId;

    /**
     * 规格值名称
     */
    @JsonProperty("name")
    private String specsName;

    /**
     * 规格类目图片，只有第一个规格类目可以定义图片
     */
    @JsonProperty("imgUrl")
    private String specsIcon;

    /**
     * 用于预览显示的规格类目图片
     */
    @JsonProperty("previewImgUrl")
    private String specsPreview;
}
