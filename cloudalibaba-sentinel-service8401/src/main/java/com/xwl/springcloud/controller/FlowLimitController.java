package com.xwl.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author xwl
 * @date 2020-03-19 22:32
 * @description
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "------testB";
    }

    @GetMapping("testD")
    public String testD() {
        // 暂停几秒钟
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info("testD 测试RT");
        log.info("testD 测试异常比例");
        int i = 1 / 0;
        return "------testD";
    }

    @GetMapping("testE")
    public String testE() {
        log.info("testD 测试异常数");
        int i = 1 / 0;
        return "------testD";
    }

    @GetMapping("testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey") // value值随意，不过一般和请求地址一致
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
//        int i = 1 / 0;
        return "------testHotKey";
    }

    /**
     * testHotKey出错调用该方法，兜底
     * @param p1
     * @param p2
     * @param exception
     * @return
     */
    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "------deal_testHotKey，o(╥﹏╥)o"; // sentinel默认提示：Blocked by Sentinel (flow limiting)
    }
}
