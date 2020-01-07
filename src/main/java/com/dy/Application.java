package com.dy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huang
 * @date 2019/10/30 17:54
 * @Disc
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.dy.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
