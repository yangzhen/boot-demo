package com.uc.server.domain.entry;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Loan {

    @Id
    private Integer id;

    private Integer customerId;

    private Integer amount;


}
