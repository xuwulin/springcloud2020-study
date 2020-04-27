package com.xwl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xwl
 * @date 2020-03-13 23:09
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderOpenFeignMain83 {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain83.class, args);
    }
}
