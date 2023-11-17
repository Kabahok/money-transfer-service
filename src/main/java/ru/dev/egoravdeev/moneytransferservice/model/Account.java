package ru.dev.egoravdeev.moneytransferservice.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private final String number;
    private final String validTiil;
    private final String cvv;
    private BigDecimal balance;
}
