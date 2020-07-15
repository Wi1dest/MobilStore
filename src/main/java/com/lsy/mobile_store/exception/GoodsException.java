package com.lsy.mobile_store.exception;

import com.lsy.mobile_store.enums.ResultEnum;
import lombok.Data;

/**
 * @Author : Lo Shu-ngan
 * @Classname GoodsException
 * @Description 自定义业务异常
 * @Date 2020/07/16 01:55
 */
@Data
public class GoodsException extends RuntimeException {
    /**
     * 异常码
     */
    private Integer code;

    /**
     * 异常提示信息
     */
    private String message;

    /**
     * 使用定义好的枚举
     * @param resultEnum 结果枚举
     */
    public GoodsException(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
    }

    /**
     * 使用定义好的枚举
     * @param errorMsg 异常信息
     */
    public GoodsException(String errorMsg){
        this.code = 1;
        this.message = errorMsg;
    }
}
