package com.xiajianhx.demo.springcloud.netflix.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@EnableEurekaClient
@FeignClient(value = "EUREKA-CLIENT")
public class HomeController {

    private String bar;

    @Autowired
    RestTemplate restTemplate;

    @ResponseBody
    @RequestMapping("/home1")
    public String hello() {
        System.out.println(restTemplate.getForObject("http://EUREKA-CLIENT/home2", String.class));
        return "Hello " + bar + "!";
    }

    @ResponseBody
    @RequestMapping("/home2")
    public String hello2() {
        return "Hello " + bar + "?";
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
