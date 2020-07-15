package com.lsy.mobile_store.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Author : Lo Shu-ngan
 * @Classname OrderForm
 * @Description 订单表单
 * @Date 2020/07/16 01:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderForm {
    /**
     * 订单姓名
     */
    @NotEmpty(message = "姓名不能为空")
    private String name;

    /**
     * 订单电话
     */
    @NotEmpty(message = "电话不能为空")
    private String tel;

    /**
     * 订单地址
     */
    @NotEmpty(message = "地址不能为空")
    private String address;

    /**
     * 订单规格
     */
    @NotNull(message = "规格不能为空")
    private Integer specsId;

    /**
     * 订单数量
     */
    @NotNull(message = "数量不能为空")
    private Integer quantity;
}
