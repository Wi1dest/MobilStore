package com.lsy.mobile_store.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : 卢树雁
 * @Classname TagUtil
 * @Description InfoVo中的Tag标签生成
 * @Date 2020/07/15 20:53
 */
public class TagUtil {
    public static List<Map<String,String>> createTag(String tag){
        // 数据库中的数据:1300万像素&USB接口  此处截取字符串中&符号
        String[] tagArray = tag.split("&");
        List<Map<String,String>> tagMapList = new ArrayList<>();
        Map<String,String> tagMap;
        for (String tagName : tagArray) {
            tagMap = new HashMap<>();
            tagMap.put("name",tagName);
            tagMapList.add(tagMap);
        }
        return tagMapList;

    }
}
