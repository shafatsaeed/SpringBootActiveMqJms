package com.example.jms.SpringBootJmsActiveMq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.jms" })
public class SpringBootJmsActiveMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJmsActiveMqApplication.class, args);
	}

}
