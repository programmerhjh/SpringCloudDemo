package com.springcloud.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class DockerServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerServiceHiApplication.class, args);
	}



}
