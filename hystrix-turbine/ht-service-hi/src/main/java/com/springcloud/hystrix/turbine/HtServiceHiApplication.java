package com.springcloud.hystrix.turbine;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 为turbine监控hystrix dashboard集群提供一个 hystrix-dashboard 服务
 */

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class HtServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtServiceHiApplication.class, args);
	}

	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	@HystrixCommand(fallbackMethod = "hiError")
	public String home(@RequestParam String name) {
		return "hi "+name+",i am from port:" +port;
	}

	public String hiError(String name) {
		return "hi,"+name+",sorry,error!";
	}


	/**
	 * 必须给每个服务的断路器监控hystrix dashboard装配一个带有urlMapping为 "/actuator/hystrix.stream" 的一个Servlet
	 * 否则turbine会报如下错误
	 * com.netflix.turbine.monitor.instance.InstanceMonitor$MisconfiguredHostException: [{"timestamp":"2018-08-09T10:07:12.249+0000","status":404,"error":"Not Found","message":"No message available","path":"/actuator/hystrix.stream"}]
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/actuator/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}

}
