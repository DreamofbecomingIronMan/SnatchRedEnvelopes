package com.zhongtongnev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource(locations = {"classpath:spring-context-ddtalk.xml"})
public class NevApplication {

    public static void main(String[] args) {
        SpringApplication.run(NevApplication.class, args);
    }

}