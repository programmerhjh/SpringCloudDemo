package com.springcloud.consul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring cloud consul 组件，它是一个提供服务发现和配置的工具。consul具有分布式、高可用、高扩展性
 * consul 具有以下性质：
 *
 *	 服务发现：consul通过http 方式注册服务，并且服务与服务之间相互感应。
 *	 服务健康监测
 *	 key/value 存储
 *	 多数据中心
 *	 consul可运行在mac windows linux 等机器上。
 *
 *	eureka,consul 两者都是服务中心，两种实现
 *	consul与eureka主要区别是consul是cp，eureka是ap
 *	consul是一个服务产品，直接安装部署服务端，客户端编码使用。(windows cmd启动)
 *	eureka是一个组件包，需要构建工程打包后用java启动服务，客户端编码使用。
 *
 *	spring cloud consul 提供的模式包括服务发现，控制总线和配置,
 *	其中Spring Cloud Consul Config就是Config Server和Client很好的替代方案。
 *	简言之，它是spring Eureka, Spring cloud Config, Spring cloud Bus的整合
 */

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulMiyaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulMiyaApplication.class, args);
	}

	@RequestMapping("/hi")
	public String home() {
		return "hi ,i'm miya";
	}


}
