package com.springcloud.hystrix.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * turbine聚合整理服务中监控的Hystrix Dashboard组件中的数据
 *
 * 通过Hystrix Dashboard去监控断路器的Hystrix command。
 * 当我们有很多个服务的时候，这就需要聚合所以服务的Hystrix Dashboard的数据了。
 * 这就需要用到Spring Cloud的另一个组件了，即Hystrix Turbine
 *
 * @EnableTurbine 注解包含了@EnableDiscoveryClient注解，即开启了注册服务
 */

@EnableTurbine
@SpringBootApplication
public class HtServiceTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtServiceTurbineApplication.class, args);
	}

}
