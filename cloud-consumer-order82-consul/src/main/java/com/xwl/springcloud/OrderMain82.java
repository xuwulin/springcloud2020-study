package com.xwl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xwl
 * @date 2020-03-13 21:12
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain82 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain82.class, args);
    }
}
