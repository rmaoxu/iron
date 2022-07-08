package com.example.iron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class IronApplication {

    public static void main(String[] args) {
        SpringApplication.run(IronApplication.class, args);
    }

}
