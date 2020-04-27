package com.xwl.springcloud.dao;

import com.xwl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author xwl
 * @date 2020-03-10 13:11
 * @description
 */
@Mapper // 推荐使用
//@Repository // 不推荐使用，有时候插入会有问题
public interface PaymentDao {

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
