package ru.dev.egoravdeev.moneytransferservice.model;

import lombok.Data;

@Data
public class Amount {
    private int value;
    private String currency;
}
