package com.uc.server.domain.dao;

import com.uc.server.config.MyMapper;
import com.uc.server.domain.entry.Loan;

import java.util.List;

public interface LoanDao extends MyMapper<Loan> {

    public List<Loan> list();

}
