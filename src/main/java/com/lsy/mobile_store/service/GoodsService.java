package com.lsy.mobile_store.service;

import com.lsy.mobile_store.vo.DataVo;
import com.lsy.mobile_store.vo.InfoVo;
import com.lsy.mobile_store.vo.SpecsVo;

import java.util.List;

/**
 * @Author : Lo Shu-ngan
 * @Classname GoodsService
 * @Description 商品服务层接口
 * @Date 2020/07/15 20:35
 */
public interface GoodsService {
    /**
     * 查询首页数据
     * @return 数据视图VO
     */
    DataVo findDataVo();

    /**
     * 根据类型查询商品信息
     * @param categoryType 类型
     * @return 商品信息
     */
    List<InfoVo> findInfoByCategoryType(Integer categoryType);

    /**
     * 根据商品ID查询商品规格
     * @param goodsId 商品ID
     * @return 商品规格
     */
    SpecsVo findSpecsByGoodsId(Integer goodsId);

    /**
     * 扣库存
     * @param specsId 规格ID
     * @param quantity 数量
     */
    void subStock(Integer specsId, Integer quantity);
}
