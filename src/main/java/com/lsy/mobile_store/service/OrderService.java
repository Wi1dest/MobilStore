package com.lsy.mobile_store.service;

import com.lsy.mobile_store.dto.OrderDTO;
import com.lsy.mobile_store.vo.OrderDetailVO;

/**
 * @Author : Lo Shu-ngan
 * @Classname OrderService
 * @Description 订单服务层接口类
 * @Date 2020/07/16 01:44
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderDTO 订单表单
     * @return 订单号
     */
    String createOrder(OrderDTO orderDTO);

    /**
     * 查询订单详情
     * @param orderId 订单ID
     * @return 订单详情
     */
    OrderDetailVO findOrderDetailByOrderId(String orderId);

    /**
     * 修改支付状态
     * @param orderId 订单ID
     * @return 订单号
     */
    String pay(String orderId);
}
