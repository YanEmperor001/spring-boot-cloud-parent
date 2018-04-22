package com.spring.boot.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootCloudProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudProviderApplication.class, args);
	}
}
