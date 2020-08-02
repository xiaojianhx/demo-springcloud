package com.xiajianhx.demo.springcloud.netflix.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableEurekaClient
public class HomeController {

    private String bar;

    @Autowired
    private DiscoveryClient client;

    @ResponseBody
    @RequestMapping("/home1")
    public String hello() {

        var EUREKA_CLIENT = client.getInstances("EUREKA-CLIENT").get(0);
        return EUREKA_CLIENT.getHost() + ":" + EUREKA_CLIENT.getPort();
    }

    @ResponseBody
    @RequestMapping("/home2")
    public String hello2() {
        return "Hello " + bar + "?";
    }
}
