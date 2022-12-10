package com.coderoom.cashapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CashappApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CashappApplication.class);
        app.setLazyInitialization(true);
        app.run(args);
    }

}
