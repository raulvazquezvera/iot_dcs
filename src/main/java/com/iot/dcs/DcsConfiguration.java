package com.iot.dcs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DcsConfiguration {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
