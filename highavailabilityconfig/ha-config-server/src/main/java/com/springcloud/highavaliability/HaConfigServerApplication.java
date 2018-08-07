package com.springcloud.highavaliability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 作为配置信息服务中心，向私库，公库或本地获取配置信息
 * 并注册到Eureka服务中心
 */

@EnableConfigServer
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class HaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaConfigServerApplication.class, args);
	}
}
