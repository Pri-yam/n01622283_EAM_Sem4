package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//@EnableDiscoveryClient  
@EnableEurekaServer
@SpringBootApplication
public class Wk7ClassActivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Wk7ClassActivityApplication.class, args);
	}

}
