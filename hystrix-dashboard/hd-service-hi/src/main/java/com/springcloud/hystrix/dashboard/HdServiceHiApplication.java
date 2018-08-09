package com.springcloud.hystrix.dashboard;

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
 * Hystrix-dashboard是一款针对Hystrix进行实时监控的工具
 * 通过Hystrix Dashboard可以直观地看到各Hystrix Command的请求响应时间，请求成功率等数据。
 *
 * 需要请求一次后台，http://localhost:8762/hystrix.stream 的ping 才有信息
 * 否则会一直ping:ping:ping:ping:ping:ping:ping:ping:ping: 无返回值
 */

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class HdServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HdServiceHiApplication.class, args);
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
	 * springboot 版本如果是2.0则需要添加 ServletRegistrationBean
	 * 因为springboot的默认路径不是 "/hystrix.stream"
	 * 只要在自己的项目里配置上下面的servlet就可以了
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getServlet() {
		// 翻开HystrixMetricsStreamServlet类，下载源码看到注释
		/*
		2) Adding the following to web.xml:
			<pre>
			{@code
				<servlet>
				 <description></description>
				 <display-name>HystrixMetricsStreamServlet</display-name>
				 <servlet-name>HystrixMetricsStreamServlet</servlet-name>
				 <servlet-class>com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet</servlet-class>
				</servlet>
				<servlet-mapping>
				 <servlet-name>HystrixMetricsStreamServlet</servlet-name>
				 <url-pattern>/hystrix.stream</url-pattern>
				</servlet-mapping>
			}
			</pre>
		*/
		// 明白在SpringBoot中可以采用装配一个ServletRegistrationBean的方式来代替上面的方式
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}

}
