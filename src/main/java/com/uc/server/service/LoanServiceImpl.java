package com.uc.server.service;

import com.uc.server.domain.manager.AccountManager;
import com.uc.server.domain.manager.LoanManager;
import org.mybatis.spring.transaction.SpringManagedTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LoanServiceImpl implements LoanService {

    @Autowired
    private AccountManager accountManager;

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    @Override
    public void repay(int user_id, int amount) {
        accountManager.repay(1,amount);

        try {
            Thread.sleep(10000);
            accountManager.recharge(1,amount*2);
            Integer.parseInt("aaa");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("100");
        }
    }
}
