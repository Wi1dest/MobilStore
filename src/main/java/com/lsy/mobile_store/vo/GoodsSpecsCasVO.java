package com.lsy.mobile_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author : Lo Shu-ngan
 * @Classname GoodsSpecsCasVO
 * @Description 商品规格信息Vo
 * @Date 2020/07/15 21:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsSpecsCasVO {
    /**
     * 规格ID
     */
    @JsonProperty("s1")
    private Integer specsId;

    /**
     * 规格价格
     */
    @JsonProperty("price")
    private BigDecimal specsPrice;

    /**
     * 规格库存
     */
    @JsonProperty("stock_num")
    private Integer specsStock;

}
