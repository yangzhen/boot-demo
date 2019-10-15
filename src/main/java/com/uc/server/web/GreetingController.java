package com.uc.server.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uc.server.domain.entry.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private TestService service;

    @RequestMapping("greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World")String name) {
    	service.name(name);
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
