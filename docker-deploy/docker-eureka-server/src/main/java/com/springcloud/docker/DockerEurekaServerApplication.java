package com.springcloud.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DockerEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerEurekaServerApplication.class, args);
	}
}
