package com.xwl.springcloud.service;

import com.xwl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author xwl
 * @date 2020-03-10 13:33
 * @description
 */
public interface PaymentService {
    /**
     * 插入
     * @param payment
     * @return 一般是返回一个数字，如果这个数字大于0表明插入成功，否则插入失败
     */
    int create(Payment payment);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
