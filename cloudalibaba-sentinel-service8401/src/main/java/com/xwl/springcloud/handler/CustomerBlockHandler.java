package com.xwl.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xwl.springcloud.common.CommonResult;
import com.xwl.springcloud.entities.Payment;

/**
 * @author xwl
 * @date 2020-03-20 13:53
 * @description
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException1(BlockException exception) {
        return new CommonResult(4444, "按客户自定义,global handlerException...1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客户自定义,global handlerException...2");
    }
}
