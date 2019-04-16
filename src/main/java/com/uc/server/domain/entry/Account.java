package com.uc.server.domain.entry;

public class Account {

    private Integer id;

    private Integer userId;

    private Integer avaliableBalance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAvaliableBalance() {
        return avaliableBalance;
    }

    public void setAvaliableBalance(Integer avaliableBalance) {
        this.avaliableBalance = avaliableBalance;
    }
}
