package com.tw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PriceEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceEngineApplication.class, args);
	}

}
