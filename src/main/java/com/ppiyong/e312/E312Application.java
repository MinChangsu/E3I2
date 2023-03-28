package com.ppiyong.e312;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class E312Application {

    public static void main(String[] args) {
        SpringApplication.run(E312Application.class, args);
    }

}
