package com.xwl.springcloud.service.impl;

import com.xwl.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author xwl
 * @date 2020-03-18 23:32
 * @description
 */
@EnableBinding(Source.class) // 定义消息的推送管道，指信道 channe和 exchange绑定在一起
public class IMessageProviderImpl implements IMessageProvider {
    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********serial：" + serial);
        return null;
    }
}
