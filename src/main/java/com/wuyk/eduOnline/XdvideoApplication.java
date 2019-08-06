package com.wuyk.eduOnline;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.wuyk.eduOnline.mapper")
//开启事务管理
@EnableTransactionManagement
public class XdvideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(XdvideoApplication.class, args);
	}
}
