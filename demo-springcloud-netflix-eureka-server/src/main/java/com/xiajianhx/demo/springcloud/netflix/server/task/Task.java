package com.xiajianhx.demo.springcloud.netflix.server.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class Task {

    @Scheduled(cron = "0/1 * * * * ?")
    public void execute() {
        System.out.println(11111);
    }
}