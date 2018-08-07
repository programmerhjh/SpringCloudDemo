package com.springcloud.highavailablilty;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取配置信息客户端
 * 将其注册微到服务注册中心，作为Eureka客户端
 */

@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@RefreshScope
@SpringBootApplication
public class HaConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaConfigClientApplication.class, args);
	}

	@Value("${foo}")
	String foo;

	@RequestMapping(value = "/hi")
	public String hi(){
		return foo;
	}
}
