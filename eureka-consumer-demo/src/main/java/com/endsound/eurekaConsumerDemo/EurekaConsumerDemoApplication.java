package com.endsound.eurekaConsumerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConsumerDemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerDemoApplication.class, args);
	}
}
