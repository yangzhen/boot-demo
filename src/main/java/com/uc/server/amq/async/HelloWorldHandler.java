package com.uc.server.amq.async;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class HelloWorldHandler {

    public void handleMessage(String text) {

        log.info("Received:" + text);

    }
}
