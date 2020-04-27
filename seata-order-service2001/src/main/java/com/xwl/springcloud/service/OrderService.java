package com.xwl.springcloud.service;

import com.xwl.springcloud.domain.Order;

public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void creat(Order order);
}