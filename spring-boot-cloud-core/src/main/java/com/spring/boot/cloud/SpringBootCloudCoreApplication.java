package com.spring.boot.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringBootCloudCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCloudCoreApplication.class, args);
	}
}
