package ru.dev.egoravdeev.moneytransferservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dev.egoravdeev.moneytransferservice.model.DataOfTransfer;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;
import ru.dev.egoravdeev.moneytransferservice.repository.AccountRepository;


@Service
public class TransferService {

    private final AccountRepository accountRepository;
    private final TransferBuilder transferBuilder;

    public TransferService (AccountRepository accountRepository, TransferBuilder transferBuilder) {
        this.accountRepository = accountRepository;
        this.transferBuilder = transferBuilder;
    }

    public Transfer createTransfer(DataOfTransfer dataOfTransfer) {
        final var accountTo = accountRepository.getAccountForNumber(dataOfTransfer.getCardToNumber());
        final var accountFrom = accountRepository.getAccountForNumber(dataOfTransfer.getCardFromNumber());

        if (!accountTo.isEmpty() && !accountFrom.isEmpty()) {
            return null;
        }

        return null;
    }
}
