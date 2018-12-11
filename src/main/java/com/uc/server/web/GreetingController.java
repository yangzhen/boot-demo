package com.uc.server.web;

import com.uc.server.domain.entry.Greeting;
import com.uc.server.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService service;

    @RequestMapping("greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World")String name,
            @RequestParam(value = "v", defaultValue = "0") String v) {
        Integer.parseInt(v);
        return service.show(name);
    }

}
