package com.uc.server.service;

import com.uc.server.domain.entry.Greeting;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class GreetingServiceImpl implements GreetingService{

    private static final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @Override
    public Greeting show(String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
