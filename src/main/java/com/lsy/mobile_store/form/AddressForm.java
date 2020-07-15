package com.lsy.mobile_store.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @Author : Lo Shu-ngan
 * @Classname AddressForm
 * @Description 地址表单
 * @Date 2020/07/15 23:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressForm {
    /**
     * 地址ID
     */
    private Integer id;

    /**
     * 姓名
     */
    @NotEmpty(message = "姓名不能为空")
    private String name;

    /**
     * 电话
     */
    @NotEmpty(message = "电话不能为空")
    private String tel;

    /**
     * 省份
     */
    @NotEmpty(message = "省不能为空")
    private String province;

    /**
     * 城市
     */
    @NotEmpty(message = "市不能为空")
    private String city;

    /**
     * 区名
     */
    @NotEmpty(message = "区不能为空")
    private String county;

    /**
     * 地方编码
     */
    @NotEmpty(message = "编码不能为空")
    private String areaCode;

    /**
     * 详细地址
     */
    @NotEmpty(message = "详细地址不能为空")
    private String addressDetail;
}
