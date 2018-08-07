package com.springcloud.hystrix.service.impl;

import com.springcloud.hystrix.service.SchedualServiceHi;
import org.springframework.stereotype.Service;

/**
 * SchedualServiceHi实现类
 * @author 洪家豪
 * Created by acer on 2018/8/7.
 */

@Service
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
