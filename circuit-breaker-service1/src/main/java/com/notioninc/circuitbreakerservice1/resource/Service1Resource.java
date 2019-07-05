package com.notioninc.circuitbreakerservice1.resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/circuitbreaker/service1")
public class Service1Resource {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getData")
    @HystrixCommand(fallbackMethod = "fallBack")
    public String getData() {

        String service2Response = restTemplate.getForObject("http://localhost:9106/circuitbreaker/service2/getState", String.class);
        return service2Response;
    }

    private String fallBack() {
        return "Circuit breaker fallback is initiated!";
    }
}
