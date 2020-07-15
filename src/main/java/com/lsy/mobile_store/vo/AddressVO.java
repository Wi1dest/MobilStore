package com.lsy.mobile_store.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Lo Shu-ngan
 * @Classname AddressVO
 * @Description 地址Vo
 * @Date 2020/07/15 23:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressVO {
    /**
     * 买家地址ID
     */
    @JsonProperty("id")
    private Integer addressId;

    /**
     * 买家名字
     */
    @JsonProperty("name")
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
     * 地址编码
     */
    @JsonProperty("areaCode")
    private String areaCode;

}
