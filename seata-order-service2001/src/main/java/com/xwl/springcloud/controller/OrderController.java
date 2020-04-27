package com.xwl.springcloud.controller;

import com.xwl.springcloud.domain.CommonResult;
import com.xwl.springcloud.domain.Order;
import com.xwl.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.creat(order);
        return new CommonResult(200, "订单创建成功！");
    }
}