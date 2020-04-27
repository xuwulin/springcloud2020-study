package com.xwl.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author xwl
 * @date 2020-03-15 22:40
 * @description
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService fall back====paymentInfo_OK，哈哈";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService fall back====paymentInfo_TimeOut，呜呜";
    }
}
