package com.xwl.springcloud.controller;

import com.xwl.springcloud.common.CommonResult;
import com.xwl.springcloud.entities.Payment;
import com.xwl.springcloud.service.PaymentOpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author xwl
 * @date 2020-03-13 23:26
 * @description
 */
@RestController
@RequestMapping("/consumer/payment")
@Slf4j
public class OrderOpenFeignController {

    @Resource
    private PaymentOpenFeignService paymentOpenFeignService;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentOpenFeignService.getPaymentById(id);
    }

    /**
     * OpenFeign超时控制演示
     * OpenFeign默认等待1秒钟，超过则报错
     *
     * @return
     */
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        return paymentOpenFeignService.paymentFeignTimeout();
    }
}
