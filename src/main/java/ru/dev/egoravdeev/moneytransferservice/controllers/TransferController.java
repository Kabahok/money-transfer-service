package ru.dev.egoravdeev.moneytransferservice.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;
import ru.dev.egoravdeev.moneytransferservice.service.TransferService;
import ru.dev.egoravdeev.moneytransferservice.model.DataOfTransfer;

@RestController
public class TransferController {
    private final TransferService transferService;

    public TransferController() {
        transferService = new TransferService();
    }


    @PostMapping("/transfer")
    public Transfer transfer(@RequestBody DataOfTransfer dataOfTransfer) {

        transferService.createTransfer(dataOfTransfer);

        return null;

    }
}
