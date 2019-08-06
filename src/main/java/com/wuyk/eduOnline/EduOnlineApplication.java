package com.wuyk.eduOnline;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wuyk.eduOnline.mapper")
public class EduOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduOnlineApplication.class, args);
    }

}
