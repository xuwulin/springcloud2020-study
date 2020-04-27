package com.xwl.springcloud.controller;

import com.xwl.springcloud.common.CommonResult;
import com.xwl.springcloud.entities.Payment;
import com.xwl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xwl
 * @date 2020-03-10 13:38
 * @description
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    /**
     * 关于服务的信息
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("====插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功，服务端口号：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败");
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("====查询结果：" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功，服务端口号：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询id：" + id);
        }
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        // 获取所有的微服务
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("******element********：" + element);
        }

        // 某个微服务下的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
            // CLOUD-PAYMENT-SERVICE	192.168.3.6	8001	http://192.168.3.6:8001
            // CLOUD-PAYMENT-SERVICE	192.168.3.6	8002	http://192.168.3.6:8002
        }
        return discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLb() {
        return serverPort;
    }

    @GetMapping(value ="/zipkin")
    public String paymentZipkin(){
        return "hi ,i'am paymentzipkin server fall back, hahaha!!";
    }
}
