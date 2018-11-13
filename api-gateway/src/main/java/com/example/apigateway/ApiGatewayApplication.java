package com.example.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r -> r.path("/eureka-consumer/**")
						.filters(gatewayFilterSpec -> gatewayFilterSpec.rewritePath("/eureka-consumer/(?<path>.*)", "/${path}"))
						.uri("lb://eureka-consumer"))
				.build();
	}
}
