package com.springcloud.eureka.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @EnableEurekaClient 标记为一个Eureka客户端，需注册到Eureka服务中心
 */
@EnableEurekaClient
@SpringBootApplication
@Controller
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	@ResponseBody
	public String home(@RequestParam(name = "name") String name) {
		return "hi " + name + ",i am from port:" + port;
	}

}
