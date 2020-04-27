package com.xwl.springcloud;

import com.xwl.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author xwl
 * @date 2020-03-10 20:36
 * @description
 */
@SpringBootApplication
@EnableEurekaClient
// 在启动该服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
@RibbonClient(name = "cloud-payment-service", configuration = MyselfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
