package ru.dev.egoravdeev.moneytransferservice.controllers;

import org.springframework.web.bind.annotation.*;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;
import ru.dev.egoravdeev.moneytransferservice.service.TransferService;
import ru.dev.egoravdeev.moneytransferservice.model.DataOfTransfer;

@RestController
@RequestMapping("")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public Transfer transfer(@RequestBody DataOfTransfer dataOfTransfer) {

        return transferService.createTransfer(dataOfTransfer);

    }
}
