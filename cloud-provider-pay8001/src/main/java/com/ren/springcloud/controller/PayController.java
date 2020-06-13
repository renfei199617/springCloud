package com.ren.springcloud.controller;

import com.ren.springcloud.entities.CommonResult;
import com.ren.springcloud.entities.Pay;
import com.ren.springcloud.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PayController {
    @Resource
    private PayService payService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/pay/create")
    public CommonResult create(@RequestBody Pay pay){
        int result = payService.create(pay);
        if(result>0){
            return new CommonResult(200,"插入数据成功:serverPort"+serverPort,result);
        }else {
            return new CommonResult(404,"插入数据失败",null);
        }
    }
    @GetMapping(value = "/pay/get/{id}")
    public CommonResult getById(@PathVariable("id") Long id){
       Pay pay = payService.getPayById(id);
        if(pay != null){
            return new CommonResult(200,"查询成功:serverPort"+serverPort,pay);
        }else {
            return new CommonResult(404,"没有相应数据",null);
        }
    }
    @GetMapping(value = "/pay/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("********service:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAY-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+
                    "\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
