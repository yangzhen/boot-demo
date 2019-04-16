package com.uc.server.domain.dao;

import com.uc.server.config.MyMapper;
import com.uc.server.domain.entry.Loan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface AccountDao extends MyMapper<Loan> {

    public int recharge(@Param("userId") int userId, @Param("amount") int amount, @Param("remark") String remark);


    @Update("update " +
            "   user_account " +
            "set " +
            "   avaliable_balance=avaliable_balance - #{amount}, remark = #{remark} " +
            "where " +
            "   user_id = #{userId}")
    public int repay(@Param("userId") int userId, @Param("amount") int amount, @Param("remark") String remark);
}
