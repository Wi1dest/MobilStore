package com.lsy.mobile_store.service.impl;

import com.lsy.mobile_store.dao.InfoDao;
import com.lsy.mobile_store.dao.OrderMasterDao;
import com.lsy.mobile_store.dao.SpecsDao;
import com.lsy.mobile_store.dto.OrderDTO;
import com.lsy.mobile_store.entity.Info;
import com.lsy.mobile_store.entity.OrderMaster;
import com.lsy.mobile_store.entity.Specs;
import com.lsy.mobile_store.enums.PayStatusEnum;
import com.lsy.mobile_store.enums.ResultEnum;
import com.lsy.mobile_store.exception.GoodsException;
import com.lsy.mobile_store.service.GoodsService;
import com.lsy.mobile_store.service.OrderService;
import com.lsy.mobile_store.util.KeyUtil;
import com.lsy.mobile_store.vo.OrderDetailVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.lsy.mobile_store.enums.ResultEnum.NOT_EXIST;
import static com.lsy.mobile_store.enums.ResultEnum.SPECS_NOT_EXIST;

/**
 * @Author : Lo Shu-ngan
 * @Classname OrderServiceImpl
 * @Description 订单服务层接口实现类
 * @Date 2020/07/16 01:46
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Autowired
    private SpecsDao specsDao;

    @Autowired
    private InfoDao infoDao;

    @Autowired
    private GoodsService goodsService;

    @Override
    public String createOrder(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        Specs specs = specsDao.findById(orderDTO.getSpecsId()).get();
        if (specs == null) {
            throw new GoodsException(SPECS_NOT_EXIST);
        }
        BeanUtils.copyProperties(specs,orderMaster);

        Info info = infoDao.findById(specs.getGoodsId()).get();
        if (info == null) {
            throw new GoodsException(NOT_EXIST);
        }
        BeanUtils.copyProperties(info,orderMaster);

        //计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount = specs.getSpecsPrice().divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getGoodsQuantity()))
                .add(orderAmount)
                .add(new BigDecimal(10));
        orderMaster.setOrderAmount(orderAmount);

        //订单ID
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderDTO.setOrderId(orderMaster.getOrderId());

        //支付状态
        orderMaster.setPayStatus(PayStatusEnum.UNPIAD.getCode());

        orderMasterDao.save(orderMaster);

        goodsService.subStock(orderDTO.getSpecsId(),orderDTO.getGoodsQuantity());

        return orderDTO.getOrderId();
    }

    /**
     * 查询订单详情
     * @param orderId 订单ID
     * @return 订单详情
     */
    @Override
    public OrderDetailVO findOrderDetailByOrderId(String orderId) {
        OrderDetailVO orderDetailVO = new OrderDetailVO();

        OrderMaster orderMaster = orderMasterDao.findById(orderId).get();

        if(orderMaster == null){
            throw new GoodsException(ResultEnum.ORDER_NOT_EXIST);
        }

        BeanUtils.copyProperties(orderMaster,orderDetailVO);
        orderDetailVO.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal(100))+".00");
        return orderDetailVO;
    }

    /**
     * 修改支付状态
     * @param orderId 订单ID
     * @return 订单号
     */
    @Override
    public String pay(String orderId) {
        OrderMaster orderMaster = orderMasterDao.findById(orderId).get();

        if(orderMaster == null){
            throw new GoodsException(ResultEnum.ORDER_NOT_EXIST);
        }

        if(orderMaster.getPayStatus().equals(PayStatusEnum.UNPIAD.getCode())){
            orderMaster.setPayStatus(PayStatusEnum.PAID.getCode());
            orderMasterDao.save(orderMaster);
        } else {
            return "订单已支付过了!";
        }

        return orderId;
    }
}
