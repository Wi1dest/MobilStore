package com.lsy.mobile_store.dao;

import com.lsy.mobile_store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : 卢树雁
 * @Classname CategoryDao
 * @Description 类别DAO层
 * @Date 2020/07/15 16:45
 */
public interface CategoryDao extends JpaRepository<Category,Integer> {
    /**
     * 根据类别编号查询类别
     * @param CategoryType 类别编号
     * @return 类别
     */
    Category findAllByCategoryType(Integer CategoryType);
}
