package springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class OrderConsulController {
    public static final String INVOKE_URL="http://consul-provider-pay";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/pay/consul")
    public String PayInfo(){

        String template = restTemplate.getForObject(INVOKE_URL + "/pay/consul", String.class);
        return template;

    }
}
