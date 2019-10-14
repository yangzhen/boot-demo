package com.uc.server.web;

import com.uc.server.config.Result;
import com.uc.server.domain.entry.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World")String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("index")
    public Result<String> index(@RequestParam("content") String content) {
        return Result.success(content);
    }

}
