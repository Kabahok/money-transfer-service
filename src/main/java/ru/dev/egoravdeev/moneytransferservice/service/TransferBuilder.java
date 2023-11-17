package ru.dev.egoravdeev.moneytransferservice.service;

import ru.dev.egoravdeev.moneytransferservice.constants.StatusOfTransfer;
import ru.dev.egoravdeev.moneytransferservice.model.Amount;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;

public class TransferBuilder {
    private String cardNumberTo;
    private String cardNumberFrom;
    private String operationId;
    private String code;
    private Amount amount;
    private StatusOfTransfer status;

    public TransferBuilder() {

    }

    public TransferBuilder addOperationId(String opearationId) {
        this.operationId = opearationId;
        return this;
    }

    public TransferBuilder addCode(String code) {
        this.code = code;
        return this;
    }

    public TransferBuilder addCardNumberTo(String cardNumberTo) {
        this.cardNumberTo = cardNumberTo;
        return this;
    }

    public TransferBuilder addCardNumberFrom(String cardNumberFrom) {
        this.cardNumberFrom = cardNumberFrom;
        return this;
    }

    public TransferBuilder addAmount(Amount amount) {
        this.amount = amount;
        return this;
    }

    public TransferBuilder addStatus(StatusOfTransfer status) {
        this.status = status;
        return this;
    }

    public Transfer build() {
        return new Transfer(operationId, code, cardNumberFrom, cardNumberTo, amount);
    }

}
