package ru.dev.egoravdeev.moneytransferservice.exception;

public class ErrorInputData extends RuntimeException {

    public ErrorInputData(String message) {
        super(message);
    }

}
