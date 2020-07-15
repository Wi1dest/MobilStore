package com.lsy.mobile_store.dao;

import com.lsy.mobile_store.entity.Specs;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : 卢树雁
 * @Classname SpecsDao
 * @Description 规格DAO层
 * @Date 2020/07/15 17:06
 */
public interface SpecsDao extends JpaRepository<Specs,Integer> {
}
