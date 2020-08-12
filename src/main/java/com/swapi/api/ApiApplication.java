package com.swapi.api;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		run(ApiApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}


}


