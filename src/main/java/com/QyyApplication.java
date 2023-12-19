package com.ccnu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.ccnu.dao")  //扫描所有dao接口
@SpringBootApplication
public class QyyApplication {
    public static void main(String[] args) {
        SpringApplication.run(QyyApplication.class, args);}
}
