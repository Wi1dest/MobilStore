package com.lsy.mobile_store.service.impl;

import com.lsy.mobile_store.dao.CategoryDao;
import com.lsy.mobile_store.dao.InfoDao;
import com.lsy.mobile_store.dao.SpecsDao;
import com.lsy.mobile_store.entity.Category;
import com.lsy.mobile_store.entity.Info;
import com.lsy.mobile_store.entity.Specs;
import com.lsy.mobile_store.enums.ResultEnum;
import com.lsy.mobile_store.exception.GoodsException;
import com.lsy.mobile_store.service.GoodsService;
import com.lsy.mobile_store.util.TagUtil;
import com.lsy.mobile_store.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author : Lo Shu-ngan
 * @Classname GoodsServiceImpl
 * @Description 商品服务层实现类
 * @Date 2020/07/15 20:37
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private InfoDao infoDao;

    @Autowired
    private SpecsDao specsDao;

    /**
     * 查询首页数据
     * @return 数据视图VO
     */
    @Override
    public DataVo findDataVo() {
        DataVo dataVo = new DataVo();

        // Data中的类型信息
        List<Category> categoryList = categoryDao.findAll();
        List<CategoryVo> categoryVoList = categoryList.stream()
                .map(e -> new CategoryVo(e.getCategoryName(),e.getCategoryType()))
                .collect(Collectors.toList());

        dataVo.setCategoryList(categoryVoList);

        // Data中的商品信息
        List<Info> infoList = infoDao.findAllByCategoryType(categoryList.get(0).getCategoryType());
        List<InfoVo> infoVoList = infoList.stream()
                .map(e -> new InfoVo(
                        e.getId(),
                        e.getName(),
                        e.getPrice(),
                        e.getDescription(),
                        TagUtil.createTag(e.getTag()),
                        e.getIcon()
                ))
                .collect(Collectors.toList());

        dataVo.setInfoList(infoVoList);

        return dataVo;
    }

    /**
     * 根据类型查询商品信息
     * @param categoryType 类型
     * @return 商品信息
     */
    @Override
    public List<InfoVo> findInfoByCategoryType(Integer categoryType) {
        List<Info> infoList = infoDao.findAllByCategoryType(categoryType);
        List<InfoVo> infoVos = infoList.stream()
                .map(e -> new InfoVo(
                        e.getId(),
                        e.getName(),
                        e.getPrice(),
                        e.getDescription(),
                        TagUtil.createTag(e.getTag()),
                        e.getIcon()
                ))
                .collect(Collectors.toList());
        return infoVos;
    }

    /**
     * 根据商品ID查询商品规格
     * @param goodsId 商品ID
     * @return 商品规格
     */
    @Override
    public SpecsVo findSpecsByGoodsId(Integer goodsId) {
        SpecsVo specsVo = new SpecsVo();
        Info info = infoDao.findById(goodsId).get();
        // specsVo中的goods部分
        Map<String, String> infoMap = new HashMap<>();
        infoMap.put("picture",info.getIcon());
        specsVo.setGoods(infoMap);

        // specsVo中的sku部分
        SkuVo skuVo = new SkuVo();
        // skuVo中的tree部分
        List<TreeVo> treeVoList = new ArrayList<>();
        TreeVo treeVo = new TreeVo();
        List<Specs> specsList = specsDao.findAllByGoodsId(goodsId);
        List<GoodsSpecsVo> goodsSpecsVoList = new ArrayList<>();
        List<GoodsSpecsCasVO> goodsSpecsCasVOList = new ArrayList<>();
        GoodsSpecsVo goodsSpecsVo;
        GoodsSpecsCasVO goodsSpecsCasVO;
        for (Specs specs : specsList) {
            goodsSpecsVo = new GoodsSpecsVo();
            BeanUtils.copyProperties(specs,goodsSpecsVo);
            goodsSpecsVoList.add(goodsSpecsVo);

            goodsSpecsCasVO = new GoodsSpecsCasVO();
            BeanUtils.copyProperties(specs,goodsSpecsCasVO);
            goodsSpecsCasVOList.add(goodsSpecsCasVO);
        }
        treeVo.setV(goodsSpecsVoList);
        treeVoList.add(treeVo);
        skuVo.setTree(treeVoList);
        // skuVo中的list部分
        skuVo.setList(goodsSpecsCasVOList);
        // skuVo中的price
        Integer price = info.getPrice().intValue();
        skuVo.setPrice(price+".00");
        // skuVo中的stock_num部分
        skuVo.setStock_num(info.getStock());

        specsVo.setSkuVo(skuVo);
        return specsVo;
    }

    /**
     * 扣库存
     * @param specsId 规格ID
     * @param quantity 数量
     */
    @Override
    @Transactional
    public void subStock(Integer specsId, Integer quantity) {
        Specs specs = specsDao.findById(specsId).get();
        Info info = infoDao.findById(specs.getGoodsId()).get();
        Integer result = specs.getSpecsStock() - quantity;
        if(result < 0){
            throw new GoodsException(ResultEnum.STOCK_ERROR);
        }

        specs.setSpecsStock(result);
        specsDao.save(specs);

        result = info.getStock() - quantity;
        if(result < 0){
            throw new GoodsException(ResultEnum.STOCK_ERROR);
        }

        info.setStock(result);
        infoDao.save(info);
    }
}
