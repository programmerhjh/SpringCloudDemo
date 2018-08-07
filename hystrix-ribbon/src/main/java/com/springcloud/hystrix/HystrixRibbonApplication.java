package com.springcloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 测试在Ribbon中使用Hystrix熔断器
 * @author 洪家豪
 * @Date 2018/8/7 12:03
 */
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix // 启用熔断器
@SpringBootApplication
public class HystrixRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
