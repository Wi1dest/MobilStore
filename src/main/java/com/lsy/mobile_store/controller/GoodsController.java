package com.lsy.mobile_store.controller;

import com.lsy.mobile_store.service.GoodsService;
import com.lsy.mobile_store.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Lo Shu-ngan
 * @Classname GoodsController
 * @Description 商品控制器
 * @Date 2020/07/16 02:41
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 查询商品首页信息
     * @return 商品首页信息
     */
    @GetMapping("/index")
    public ResultUtil index(){
        return ResultUtil.success(goodsService.findDataVo());
    }

    /**
     * 根据类型查找商品
     * @param categoryType 商品类型
     * @return 商品信息
     */
    @GetMapping("/goods/{categoryType}")
    public ResultUtil findByCategoryType(@PathVariable("categoryType") Integer categoryType){
        return ResultUtil.success(goodsService.findInfoByCategoryType(categoryType));
    }

    /**
     * 根据商品ID查询商品规格
     * @param goodsId 商品ID
     * @return 商品规格
     */
    @GetMapping("/goods/{goodsId}")
    public ResultUtil findSpecsByGoodsId(@PathVariable("goodsId") Integer goodsId){
        return ResultUtil.success(goodsService.findSpecsByGoodsId(goodsId));
    }
}
