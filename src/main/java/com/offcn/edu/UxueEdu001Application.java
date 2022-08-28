package com.offcn.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.offcn.edu.dao")
public class UxueEdu001Application {

    public static void main(String[] args) {
        SpringApplication.run(UxueEdu001Application.class, args);
    }

}
