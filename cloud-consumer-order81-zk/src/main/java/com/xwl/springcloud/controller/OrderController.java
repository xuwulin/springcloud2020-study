package com.xwl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xwl
 * @date 2020-03-10 20:44
 * @description
 */
@RestController
@Slf4j
@RequestMapping("/consumer/payment")
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001"; // 单机版
    public static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    /**
     * http://localhost:81/consumer/payment/zk
     *
     * @return
     */
    @GetMapping("/zk")
    public String paymentInfo() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
