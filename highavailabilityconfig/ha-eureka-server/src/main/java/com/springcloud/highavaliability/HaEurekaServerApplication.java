package com.springcloud.highavaliability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 作为服务注册中心
 */

@EnableEurekaServer
@SpringBootApplication
public class HaEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaEurekaServerApplication.class, args);
	}
}
