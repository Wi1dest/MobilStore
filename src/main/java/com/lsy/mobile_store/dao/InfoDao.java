package com.lsy.mobile_store.dao;

import com.lsy.mobile_store.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author : 卢树雁
 * @Classname InfoDao
 * @Description 商品信息类DAO层
 * @Date 2020/07/15 16:57
 */
public interface InfoDao extends JpaRepository<Info,Integer> {
    /**
     * 根据类别编号查询商品信息
     * @param categoryType 类别编号
     * @return 商品信息
     */
    List<Info> findAllByCategoryType(Integer categoryType);
}
