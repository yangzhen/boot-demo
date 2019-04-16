package com.uc.server.domain.manager;

import com.uc.server.domain.dao.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AccountManager {

    @Autowired
    private AccountDao dao;

    public int recharge(int userId, int amount) {
        try {

            int result = dao.recharge(userId, amount,"充钱");
            if(result == 0) {
                throw new RuntimeException("事物处理异常");
            }
            return result;
        } catch (Exception e) {
            log.error("db error", e);
            throw new RuntimeException("事物处理异常");
        }
    }

    public int repay(int userId, int amount) {
        try {

            int result = dao.repay(userId, amount,"扣钱");
            if(result == 0) {
                throw new RuntimeException("事物处理异常");
            }
            return result;
        } catch (Exception e) {
            log.error("db error", e);
            throw new RuntimeException("事物处理异常");
        }
    }
}
