package com.xiaojianhx.demo.springcloud.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HomeController {

    @Value("${env.name:World!}")
    private String bar;

    @RequestMapping("/app")
    String hello() {
        return "Hello " + bar + "!";
    }
}
