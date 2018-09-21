package com.uc.server.amq.async;

import java.util.concurrent.atomic.AtomicLong;

public class HelloWorldHandler {

    AtomicLong counter = new AtomicLong();


    public void handleMessage(String text) {

        System.out.println("Received:" + text+",count:" + counter.incrementAndGet());

    }
}
