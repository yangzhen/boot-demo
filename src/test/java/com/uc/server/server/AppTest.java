package com.uc.server.server;

import com.uc.server.Application;
import com.uc.server.domain.entry.Loan;
import com.uc.server.domain.manager.LoanManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class AppTest {

    Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private LoanManager loanManager;

    @Test
    public void testFind() {

        logger.info("loanManager:" + loanManager);

        Loan loanEntry = loanManager.findById(6);

        logger.info("loanInfo:" + loanEntry);

        Assert.assertNotNull(loanEntry);
    }
}
