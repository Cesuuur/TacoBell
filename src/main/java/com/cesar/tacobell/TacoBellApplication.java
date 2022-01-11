package com.cesar.tacobell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication // @Configuration, @EnableAutoConfiguration, and @ComponentScan.
@EnableJpaRepositories
public class TacoBellApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoBellApplication.class, args);
    }
}