package ru.dev.egoravdeev.moneytransferservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.dev.egoravdeev.moneytransferservice.exception.ErrorInputData;
import ru.dev.egoravdeev.moneytransferservice.exception.ErrorTransfer;
import ru.dev.egoravdeev.moneytransferservice.exception.ResponseError;

@RestControllerAdvice
public class ExceptionHandlerAdvice {



    @ExceptionHandler(ErrorInputData.class)
    public ResponseEntity<ResponseError> errorInputDataHandler(ErrorInputData e) {
        System.out.println("ХУУУУУУУУУЙ");
        return new ResponseEntity<>(new ResponseError(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorTransfer.class)
    public ResponseEntity<ResponseError> errorTransferHandler(ErrorTransfer e) {
        return new ResponseEntity<>(new ResponseError(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
