package com.uc.server.server;

import com.uc.server.Application;
import com.uc.server.amq.boot.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class RabbitTests {
    
    @Autowired
    private Sender sender;
    
    @Test
    public void sendTest() throws Exception {
        while(true){
            String msg = new Date().toString();
            sender.send(msg);
            Thread.sleep(1000);
        }
    }
}