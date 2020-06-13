package com.ren.springcloud.controller;

import com.ren.springcloud.entities.CommonResult;
import com.ren.springcloud.entities.Pay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    public static final String PAY_URL = "http://CLOUD-PAY-SERVICE";

    //public static final String PAY_URL="http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/create")
    public CommonResult<Pay> create(Pay pay){
        return restTemplate.postForObject(PAY_URL+"/pay/create",pay,CommonResult.class);
    }
    @GetMapping("/consumer/pay/get/{id}")
    public CommonResult<Pay> getPay(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAY_URL+"/pay/get/"+id,CommonResult.class);
    }
}
