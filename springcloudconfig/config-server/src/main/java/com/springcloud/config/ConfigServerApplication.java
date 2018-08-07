package com.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * spring cloud config 组件中的 server角色
 * @EnableConfigServer 注解开启配置服务器的功能
 *
 * 启动程序：访问http://localhost:8888/foo/dev
 * 配置服务中心可以从远程程序获取配置信息
 *
 * http请求地址和资源文件映射如下:
 *
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 *
 */

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
