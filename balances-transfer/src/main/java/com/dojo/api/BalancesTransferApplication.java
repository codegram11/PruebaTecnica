package com.dojo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dojo.api")
public class BalancesTransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(BalancesTransferApplication.class, args);
    }

}
