package com.edupath.msroadmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsRoadmapApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRoadmapApplication.class, args);
    }

}
