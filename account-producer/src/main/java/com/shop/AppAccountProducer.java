package com.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shop.mapper") //@MapperScan 用户扫描MyBatis的Mapper接口
public class AppAccountProducer {

	public static void main(String[] args) {
		SpringApplication.run(AppAccountProducer.class, args);
	}
}
