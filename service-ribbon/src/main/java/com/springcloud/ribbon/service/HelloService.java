package com.springcloud.ribbon.service;

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
     * @param name
     * @return
     */
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

}
