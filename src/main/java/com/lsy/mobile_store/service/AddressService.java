package com.lsy.mobile_store.service;

import com.lsy.mobile_store.form.AddressForm;
import com.lsy.mobile_store.vo.AddressVO;

import java.util.List;

/**
 * @Author : Lo Shu-ngan
 * @Classname AddressService
 * @Description 地址服务层接口
 * @Date 2020/07/15 23:11
 */
public interface AddressService {
    /**
     * 查询所有地址
     * @return 地址集合
     */
    List<AddressVO> findAllAddress();

    /**
     * 新增地址
     * @param addressForm 地址表单
     */
    void saveAddress(AddressForm addressForm);
}
