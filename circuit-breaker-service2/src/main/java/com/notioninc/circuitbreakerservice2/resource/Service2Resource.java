package com.notioninc.circuitbreakerservice2.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circuitbreaker/service2")
public class Service2Resource {

    @GetMapping("/getState")
    public String getState() {
        return "Service is Active";
    }
}
