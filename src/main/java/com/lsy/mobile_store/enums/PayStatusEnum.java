package com.lsy.mobile_store.enums;

import lombok.Getter;

/**
 * @Author : Lo Shu-ngan
 * @Classname PayStatusEnum
 * @Description 支付状态枚举
 * @Date 2020/07/16 02:08
 */
@Getter
public enum PayStatusEnum {
    UNPIAD(0,"未支付"),
    PAID(1,"已支付");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
