package com.lsy.mobile_store.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Author : Lo Shu-ngan
 * @Classname ResultUtil
 * @Description 通用返回对象
 * @Date 2020/07/16 02:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultUtil {
    /**
     * 状态码
     */
    private int code;

    /**
     * 提示语句
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 成功操作
     * @param data 返回数据
     * @return 通用返回对象
     */
    public static ResultUtil success(Object data){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setMsg("成功");
        resultUtil.setData(data);
        return resultUtil;
    }

    /**
     * 失败操作
     * @param data 返回数据
     * @return 通用返回对象
     */
    public static ResultUtil error(Object data){
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(1);
        resultUtil.setMsg("失败");
        resultUtil.setData(data);
        return resultUtil;
    }
}
