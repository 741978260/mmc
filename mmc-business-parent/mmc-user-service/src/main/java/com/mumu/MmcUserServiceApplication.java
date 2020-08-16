package com.mumu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MmcUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmcUserServiceApplication.class, args);
    }

}
