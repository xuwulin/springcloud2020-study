package com.xwl.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.xwl.springcloud.dao"})
public class MyBatisConfig {
}