package com.xwl.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xwl
 * @date 2020-03-13 22:08
 * @description
 */
@Configuration
public class MyselfRule {

    /**
     * 定义随机负载均衡策略
     * @return
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }
}
