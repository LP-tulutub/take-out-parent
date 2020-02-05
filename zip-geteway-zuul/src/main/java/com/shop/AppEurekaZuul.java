package com.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class AppEurekaZuul {

	public static void main(String[] args) {
		SpringApplication.run(AppEurekaZuul.class, args);
	}

}
