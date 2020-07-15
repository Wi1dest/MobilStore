package com.lsy.mobile_store.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author : 卢树雁
 * @Classname DataVo
 * @Description 数据VO
 * @Date 2020/07/15 20:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataVo {
    /**
     * 类别集合
     */
    List<CategoryVo> categoryList;

    /**
     * 商品信息集合
     */
    List<InfoVo> infoList;
}
