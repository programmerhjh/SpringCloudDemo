package com.springcloud.highavailability.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试高可用服务注册中心 EurekaClient
 * 提供 service-hi 服务
 */

@RestController
@EnableEurekaClient
@SpringBootApplication
public class HaEurekaServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaEurekaServiceHiApplication.class, args);
	}
}
