package com.uc.server.web;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import com.uc.server.config.Result;
import com.uc.server.domain.entry.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
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

    @GetMapping("index")
    public Result<String> index(@RequestParam("content") String content) {
        return Result.success(content);
    }

    public static void main(String[] args) {
        Class<?> cc = GreetingController.class;
        Annotation[] annotations = cc.getAnnotations();
        Arrays.stream(annotations).forEach(t-> System.out.println(t.annotationType().getName()));
    }

}
