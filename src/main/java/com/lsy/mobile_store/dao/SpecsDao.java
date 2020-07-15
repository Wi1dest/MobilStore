package com.lsy.mobile_store.dao;

import com.lsy.mobile_store.entity.Specs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author : Lo Shu-ngan
 * @Classname SpecsDao
 * @Description 规格DAO层
 * @Date 2020/07/15 17:06
 */
public interface SpecsDao extends JpaRepository<Specs,Integer> {
    /**
     * 根据商品ID查询商品规格
     * @param goodsId 商品ID
     * @return 商品规格集合
     */
    List<Specs> findAllByGoodsId(Integer goodsId);
}
