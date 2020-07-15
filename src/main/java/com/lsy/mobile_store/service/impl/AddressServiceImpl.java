package com.lsy.mobile_store.service.impl;

import com.lsy.mobile_store.dao.BuyerAddressDao;
import com.lsy.mobile_store.entity.BuyerAddress;
import com.lsy.mobile_store.form.AddressForm;
import com.lsy.mobile_store.service.AddressService;
import com.lsy.mobile_store.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Lo Shu-ngan
 * @Classname AddressServiceImpl
 * @Description 地址服务层接口实现类
 * @Date 2020/07/15 23:13
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private BuyerAddressDao buyerAddressDao;

    /**
     * 查询所有地址
     * @return
     */
    @Override
    public List<AddressVO> findAllAddress() {
        List<BuyerAddress> buyerAddressList = buyerAddressDao.findAll();
        List<AddressVO> addressVOList = buyerAddressList.stream()
                .map(e -> new AddressVO(
                        e.getAddressId(),
                        e.getBuyerName(),
                        e.getBuyerPhone(),
                        e.getBuyerAddress(),
                        e.getAreaCode()
                ))
                .collect(Collectors.toList());
        return addressVOList;
    }

    @Override
    public void saveAddress(AddressForm addressForm) {
        BuyerAddress buyerAddress;
        //当表单地址ID为null时说明是新增地址
        if (addressForm.getId() == null) {
            buyerAddress = new BuyerAddress();
        }else {
            //当表单地址ID不为null时说明要对地址进行更新
            buyerAddress = buyerAddressDao.findById(addressForm.getId()).get();
        }
        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        // 用StringBuilder对详细地址(从省份开始到具体地址)进行拼接
        StringBuilder address = new StringBuilder();
        address.append(addressForm.getProvince())
                .append(addressForm.getCity())
                .append(addressForm.getCounty())
                .append(addressForm.getAddressDetail());
        buyerAddress.setBuyerAddress(address.toString());
        buyerAddress.setAreaCode(addressForm.getAreaCode());
        buyerAddressDao.save(buyerAddress);
    }
}
