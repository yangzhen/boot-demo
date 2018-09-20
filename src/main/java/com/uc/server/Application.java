package com.uc.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan
@EnableAspectJAutoProxy
@ImportResource(locations = "classpath:application-context.xml")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}
