package ru.dev.egoravdeev.moneytransferservice.model;

import lombok.Data;

@Data
public class Transfer {
    private String operationId;
    private String code;

}
