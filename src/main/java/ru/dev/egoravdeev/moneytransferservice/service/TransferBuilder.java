package ru.dev.egoravdeev.moneytransferservice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;

@Component
public class TransferBuilder {
    private String operationId;
    private String code;

    public TransferBuilder() {

    }

    public void addOperationId(String opearationId) {
        this.operationId = opearationId;
    }

    public void addCode(String code) {
        this.code = code;
    }

    public Transfer build() {
        return new Transfer(operationId, code);
    }

}
