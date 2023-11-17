package ru.dev.egoravdeev.moneytransferservice.service;

import ru.dev.egoravdeev.moneytransferservice.model.DataOfTransfer;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;
import ru.dev.egoravdeev.moneytransferservice.repository.AccountRepository;

public class TransferService {
    private AccountRepository accountRepository;

    public TransferService () {
        accountRepository = new AccountRepository();
    }

    public Transfer createTransfer(DataOfTransfer dataOfTransfer) {
        final var accountTo = accountRepository.getAccountForNumber(dataOfTransfer.getCardToNumber());
        final var accountFrom = accountRepository.getAccountForNumber(dataOfTransfer.getCardFromNumber());

        if (!accountTo.isEmpty() && !accountFrom.isEmpty()) {

        }
    }
}
