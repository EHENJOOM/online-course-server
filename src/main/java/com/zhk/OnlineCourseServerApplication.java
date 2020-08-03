package com.zhk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 赵洪苛
 * @date 2020/07/31 20:21
 * @description
 */
@MapperScan("com.zhk.dao")
@SpringBootApplication
public class OnlineCourseServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineCourseServerApplication.class, args);
    }

}
