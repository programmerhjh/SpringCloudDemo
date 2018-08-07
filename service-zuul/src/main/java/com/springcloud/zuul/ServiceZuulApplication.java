package com.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 在其入口applicaton类加上注解@EnableZuulProxy，开启zuul的功能
 *
 * Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如/api/user转发到到user服务，/api/shop转发到到shop服务。
 * zuul默认和Ribbon结合实现了负载均衡的功能。
 *
 * zuul有以下功能：
 * 	 Authentication
 *	 Insights
 *	 Stress Testing
 *	 Canary Testing
 *	 Dynamic Routing
 *	 Service Migration
 *	 Load Shedding
 *	 Security
 *	 Static Response handling
 *	 Active/Active traffic management
 *
 */

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class ServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceZuulApplication.class, args);
	}
}
