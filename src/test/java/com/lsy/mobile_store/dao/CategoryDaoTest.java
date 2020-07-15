package com.lsy.mobile_store.dao;

import com.lsy.mobile_store.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author : Lo Shu-ngan
 * @Classname CategoryDaoTest
 * @Description TODO
 * @Date 2020/07/15 16:47
 */
@SpringBootTest
class CategoryDaoTest {
    @Autowired
    private CategoryDao categoryDao;

    @Test
    void Test(){
        List<Category> all = categoryDao.findAll();
        for (Category category : all) {
            System.out.println(category);
        }
    }

    @Test
    void Test1(){
        Category categoriesByCategoryType = categoryDao.findAllByCategoryType(1);
        System.out.println("categoriesByCategoryType = " + categoriesByCategoryType);
    }
}