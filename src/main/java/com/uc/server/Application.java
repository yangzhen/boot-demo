package com.uc.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan({"com.uc.server.domain.dao"})
@SpringBootApplication
@ImportResource("classpath:themis-log-context.xml")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}
