package com.springcloud.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 作为消息总线例子的信息服务中心
 */

@EnableConfigServer
@SpringBootApplication
public class ScbConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScbConfigServerApplication.class, args);
	}
}
