package com.uc.server.amq.async;

import java.util.concurrent.atomic.AtomicLong;

public class HelloWorldHandler {

    public void handleMessage(String text) {

        System.out.println("Received:" + text);

    }
}
