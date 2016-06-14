package com.superhao.spring.cloud.config.client1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SpringConfigClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClient1Application.class, args);
	}
}
