package com.uc.server.server;

import com.uc.server.Application;
import com.uc.server.service.LoanService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
@Slf4j
public class LoanServiceTest {

    @Autowired
    private LoanService loanService;

    @Test
    public void test() {
        log.info("------loanService:" + loanService);
        loanService.repay(1,100);
    }
}
