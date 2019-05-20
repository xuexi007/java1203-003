package com.offcn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Day024JpaDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Day024JpaDemo1Application.class, args);
    }

}
