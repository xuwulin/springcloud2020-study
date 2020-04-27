package com.xwl.springcloud.service.impl;

import com.xwl.springcloud.dao.PaymentDao;
import com.xwl.springcloud.entities.Payment;
import com.xwl.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xwl
 * @date 2020-03-10 13:34
 * @description
 */
@Service
public class PaymentServiceImpl implements PaymentService {

//    @Autowired // spring的注解，可以依赖注入
    @Resource // java自带的注解，也可以依赖注入
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
