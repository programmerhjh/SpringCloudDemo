package com.springcloud.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 作为消息总线例子的服务注册中心
 */

@EnableEurekaServer
@SpringBootApplication
public class ScbEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScbEurekaServerApplication.class, args);
	}
}
