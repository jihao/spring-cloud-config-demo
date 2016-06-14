package com.superhao.spring.cloud.config.client1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HomeController {
	@Autowired
	private Environment env;

	@Value("${message}")
	private String message;

	@RequestMapping(value = "/greeting")
	public String greeting() {
		return String.format("Hello %s", message);
	}
	
	@RequestMapping(value = "/greeting2")
	public String greeting2() {
		return String.format("Hello again, %s", env.getProperty("message"));
	}
}
