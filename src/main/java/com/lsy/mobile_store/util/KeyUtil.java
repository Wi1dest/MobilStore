package com.lsy.mobile_store.util;

import java.util.Random;

/**
 * @Author : Lo Shu-ngan
 * @Classname KeyUtil
 * @Description 订单ID生成
 * @Date 2020/07/16 02:07
 */
public class KeyUtil {
    public static synchronized String createUniqueKey(){
        Random random = new Random();
        Integer key = random.nextInt(900000)+100000;
        return System.currentTimeMillis() + String.valueOf(key);
    }
}
