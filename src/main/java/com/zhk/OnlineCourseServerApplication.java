package com.zhk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@MapperScan("com.zhk.dao")
@SpringBootApplication
public class OnlineCourseServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineCourseServerApplication.class, args);
    }

}
