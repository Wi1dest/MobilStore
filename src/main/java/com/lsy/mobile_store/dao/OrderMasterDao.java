package com.lsy.mobile_store.dao;

import com.lsy.mobile_store.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : Lo Shu-ngan
 * @Classname OrderMasterDao
 * @Description 订单DAO层
 * @Date 2020/07/15 17:20
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
}
