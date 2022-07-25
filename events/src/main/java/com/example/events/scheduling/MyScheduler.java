package com.example.events.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {

    private int seconds = 0;

    @Scheduled(fixedRate = 1000)
    public void doSomeWork(){
        System.out.println("I am starting on every second!" + (++seconds));
    }
}
