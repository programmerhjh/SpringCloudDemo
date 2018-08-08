package com.springcloud.highavailability.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 高可用Eureka服务注册中心 实现集群实例
 * 文档地址： http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/single/spring-cloud.html
 *
 * Eureka-server peer1 8761,Eureka-server peer2 8769相互感应
 * 当有服务注册时，两个Eureka-server是对等的，它们都存有相同的信息，这就是通过服务器的冗余来增加可靠性
 * 当有一台服务器宕机了，服务并不会终止，因为另一台服务存有相同的数据
 */

@EnableEurekaServer
@SpringBootApplication
public class HaEurekaClusterServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaEurekaClusterServerApplication.class, args);
	}
}
