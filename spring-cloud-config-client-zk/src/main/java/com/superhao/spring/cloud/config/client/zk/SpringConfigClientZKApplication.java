package com.superhao.spring.cloud.config.client.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class SpringConfigClientZKApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigClientZKApplication.class, args);
	}
}
