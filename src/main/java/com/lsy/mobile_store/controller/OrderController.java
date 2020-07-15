package com.lsy.mobile_store.controller;

import com.lsy.mobile_store.dto.OrderDTO;
import com.lsy.mobile_store.exception.GoodsException;
import com.lsy.mobile_store.form.OrderForm;
import com.lsy.mobile_store.service.OrderService;
import com.lsy.mobile_store.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Lo Shu-ngan
 * @Classname OrderController
 * @Description 订单控制器
 * @Date 2020/07/16 02:37
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderForm 订单表单
     * @param bindingResult 订单属性校验结果
     * @return 订单号
     */
    @PostMapping("/order")
    public ResultUtil create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new GoodsException(bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getTel());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setSpecsId(orderForm.getSpecsId());
        orderDTO.setGoodsQuantity(orderForm.getQuantity());

        String result = orderService.createOrder(orderDTO);

        Map<String,String> map = new HashMap<>();
        map.put("orderId",result);

        return ResultUtil.success(map);
    }

    /**
     * 查询订单详情
     * @param orderId 订单ID
     * @return 订单详情
     */
    @GetMapping("/detail/{orderId}")
    public ResultUtil findOrederDetail(@PathVariable("orderId") String orderId){
        return ResultUtil.success(orderService.findOrderDetailByOrderId(orderId));
    }

    /**
     * 修改订单支付状态
     * @param orderId 订单ID
     * @return 支付状态
     */
    @PutMapping("/pay/{orderId}")
    public ResultUtil pay(@PathVariable("orderId") String orderId){
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderService.pay(orderId));
        return ResultUtil.success(map);
    }
}
