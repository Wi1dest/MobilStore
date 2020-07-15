package com.lsy.mobile_store.dao;

import com.lsy.mobile_store.entity.BuyerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : 卢树雁
 * @Classname BuyerAddressDao
 * @Description 买家地址DAO层
 * @Date 2020/07/15 17:26
 */
public interface BuyerAddressDao extends JpaRepository<BuyerAddress,Integer> {
}
