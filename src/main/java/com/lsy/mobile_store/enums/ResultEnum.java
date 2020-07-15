package com.lsy.mobile_store.enums;

import lombok.Getter;

/**
 * @Author : Lo Shu-ngan
 * @Classname ResultEnum
 * @Description 结果枚举
 * @Date 2020/07/16 01:57
 */
@Getter
public enum ResultEnum {
    STOCK_ERROR(0,"商品库存不足"),
    ORDER_NOT_EXIST(1,"订单不存在"),
    SPECS_NOT_EXIST(2,"规格不存在"),
    NOT_EXIST(3,"商品不存在");
    ;
    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
