package com.xwl.springcloud.service;

import com.xwl.springcloud.common.CommonResult;
import com.xwl.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xwl
 * @date 2020-03-13 23:15
 * @description
 */
@Component
// Feign客户端，要去调用cloud-provider-payment服务的接口，如com.xwl.springcloud.controller.PaymentController中的方法
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") // value值是要调用的微服务的名字
@RequestMapping("/payment")
public interface PaymentOpenFeignService {
    @GetMapping("/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/feign/timeout")
    String paymentFeignTimeout();
}
