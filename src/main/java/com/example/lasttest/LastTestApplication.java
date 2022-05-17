package com.example.lasttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LastTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LastTestApplication.class, args);
    }

}
