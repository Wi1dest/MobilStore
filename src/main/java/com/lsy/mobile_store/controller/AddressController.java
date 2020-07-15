package com.lsy.mobile_store.controller;

import com.lsy.mobile_store.exception.GoodsException;
import com.lsy.mobile_store.form.AddressForm;
import com.lsy.mobile_store.service.AddressService;
import com.lsy.mobile_store.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Author : Lo Shu-ngan
 * @Classname AddressController
 * @Description 地址控制器
 * @Date 2020/07/16 02:32
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 获取全部地址
     * @return 地址
     */
    @GetMapping("/address")
    public ResultUtil list(){
        return ResultUtil.success(addressService.findAllAddress());
    }

    /**
     * 添加地址
     * @param addressForm 地址表单
     * @param bindingResult 地址属性校验结果
     * @return 无
     */
    @PostMapping("/address")
    public ResultUtil create(@Valid @RequestBody AddressForm addressForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new GoodsException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveAddress(addressForm);

        return ResultUtil.success(null);
    }

    /**
     * 更新地址
     * @param addressForm 地址表单
     * @param bindingResult 地址属性校验结果
     * @return 无
     */
    @PutMapping("/address")
    public ResultUtil update(@Valid @RequestBody AddressForm addressForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new GoodsException(bindingResult.getFieldError().getDefaultMessage());
        }

        addressService.saveAddress(addressForm);

        return ResultUtil.success(null);
    }
}
