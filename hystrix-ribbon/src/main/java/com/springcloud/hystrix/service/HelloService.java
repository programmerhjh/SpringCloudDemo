package com.springcloud.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 测试Service
 * @author 洪家豪
 * Created by acer on 2018/8/7.
 */

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 当sercvice-ribbon通过restTemplate调用service-hi的hi接口时
     * 因为用ribbon进行了负载均衡，会轮流的调用service-hi:8762和8763两个端口的hi接口
     *
     * hiService方法上加上@HystrixCommand注解，该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    /**
     * 返回了一个字符串，字符串为”hi,”+name+”,sorry,error!”
     * @param name
     * @return
     */
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
