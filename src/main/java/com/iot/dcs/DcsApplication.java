package com.iot.dcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class DcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcsApplication.class, args);
	}

}
