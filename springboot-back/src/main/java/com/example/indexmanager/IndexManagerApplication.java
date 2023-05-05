package com.example.indexmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.indexmanager.mapper")
public class IndexManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndexManagerApplication.class, args);
    }

}
