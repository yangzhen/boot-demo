package com.uc.server.domain.manager;

import com.uc.server.domain.dao.LoanDao;
import com.uc.server.domain.entry.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoanManager {

    @Autowired
    private LoanDao loanDao;

    private static final Logger logger = LoggerFactory.getLogger(LoanManager.class);

    public List<Loan> getList() {
        try {
            return loanDao.list();
        } catch (Exception e) {
            logger.error("db error", e);
        }
        throw  new RuntimeException("db error");
    }

    public Loan findById(Integer loanId){
        try {
            Loan loan = new Loan();
            loan.setId(loanId);
            return loanDao.selectByPrimaryKey(loan);
        } catch (Exception e) {
            logger.error("db error", e);
        }
        throw  new RuntimeException("db error");
    }

}
