package com.xwl.springcloud.controller;

import com.xwl.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xwl
 * @date 2020-03-18 23:34
 * @description
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider massageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return massageProvider.send();
    }
}