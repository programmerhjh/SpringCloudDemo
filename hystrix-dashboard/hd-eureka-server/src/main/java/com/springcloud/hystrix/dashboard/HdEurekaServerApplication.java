package com.springcloud.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 作为服务注册中心
 */

@SpringBootApplication
@EnableEurekaServer
public class HdEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HdEurekaServerApplication.class, args);
	}
}
