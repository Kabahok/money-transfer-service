package ru.dev.egoravdeev.moneytransferservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter
public class Transfer {
    private String operationId;

    @JsonIgnore
    private String code;

    public Transfer(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }
}
