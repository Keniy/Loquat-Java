package com.loquat.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.loquat.user.mapper")
public class SpringBootLoquatUserApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoquatUserApplication.class, args);
	}
}
