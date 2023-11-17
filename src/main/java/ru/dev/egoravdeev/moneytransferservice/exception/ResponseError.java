package ru.dev.egoravdeev.moneytransferservice.exception;

import lombok.Data;
import lombok.Getter;

@Getter
public class ResponseError {
    private String message;
    private int id;

    public ResponseError(String message, int id) {
        this.message = message;
        this.id = id;
    }

}
