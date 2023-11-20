package ru.dev.egoravdeev.moneytransferservice.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;

@RestController
public class ConfirmController {

    @PostMapping
    public Transfer confirm(@JsonProperty String operationId, @JsonProperty String code) {
        
    }

}
