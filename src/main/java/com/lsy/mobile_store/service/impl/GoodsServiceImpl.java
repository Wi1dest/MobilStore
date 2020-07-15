package com.lsy.mobile_store.service.impl;

import com.lsy.mobile_store.dao.CategoryDao;
import com.lsy.mobile_store.dao.InfoDao;
import com.lsy.mobile_store.entity.Category;
import com.lsy.mobile_store.entity.Info;
import com.lsy.mobile_store.service.GoodsService;
import com.lsy.mobile_store.util.TagUtil;
import com.lsy.mobile_store.vo.CategoryVo;
import com.lsy.mobile_store.vo.DataVo;
import com.lsy.mobile_store.vo.InfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : 卢树雁
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

    @Override
    public DataVo findDataVo() {
        DataVo dataVo = new DataVo();
        List<Category> categoryList = categoryDao.findAll();

/*        List<CategoryVo> categoryVoList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryVo categoryVo = new CategoryVo();
            BeanUtils.copyProperties(category,categoryVo);
            categoryVoList.add(categoryVo);
        }*/
        List<CategoryVo> categoryVoList = categoryList.stream()
                .map(e -> new CategoryVo(e.getCategoryName(),e.getCategoryType()))
                .collect(Collectors.toList());

        dataVo.setCategoryList(categoryVoList);

        List<Info> infoList = infoDao.findAllByCategoryType(categoryList.get(0).getCategoryType());
/*        List<InfoVo> infoVoList = new ArrayList<>();
        for (Info info : infoList) {
            InfoVo infoVo = new InfoVo();
            BeanUtils.copyProperties(info,infoVo);
            infoVo.setTag(TagUtil.createTag(info.getTag()));
            infoVoList.add(infoVo);
        }*/
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
}
