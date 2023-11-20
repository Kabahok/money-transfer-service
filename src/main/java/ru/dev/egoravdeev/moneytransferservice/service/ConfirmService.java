package ru.dev.egoravdeev.moneytransferservice.service;

import org.springframework.stereotype.Service;
import ru.dev.egoravdeev.moneytransferservice.exception.ConfirmError;
import ru.dev.egoravdeev.moneytransferservice.exception.ErrorInputData;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;
import ru.dev.egoravdeev.moneytransferservice.repository.AccountRepository;
import ru.dev.egoravdeev.moneytransferservice.repository.MoneyTransferRepository;
import ru.dev.egoravdeev.moneytransferservice.util.MoneyTransfer;

@Service
public class ConfirmService {

    private final MoneyTransferRepository moneyTransferRepository;
    private final AccountRepository accountRepository;
    private final MoneyTransfer moneyTransfer;

    public ConfirmService(MoneyTransferRepository moneyTransferRepository, AccountRepository accountRepository, MoneyTransfer moneyTransfer) {
        this.moneyTransferRepository = moneyTransferRepository;
        this.accountRepository = accountRepository;
        this.moneyTransfer = moneyTransfer;
    }

    public Transfer confirmOperation(String operationId, String code) throws ConfirmError, ErrorInputData {
        final var transfer = moneyTransferRepository.getTransfer(operationId);

        if (transfer.isPresent() && transfer.get().getCode().equals(code)) {

            final var accountFrom = accountRepository.getAccountForNumber(transfer.get().getCardNumberFrom());
            final var accountTo = accountRepository.getAccountForNumber(transfer.get().getCardNumberTo());

            if (accountTo.isPresent() && accountFrom.isPresent()) {
                if (moneyTransfer.transferMoney(accountTo.get(), accountFrom.get(), transfer.get())) {
                    return transfer.get();
                }
                throw new ConfirmError("Операция не может быть выполнена");

            }

            throw new ErrorInputData("Некорректные данные");

        }

        throw new ConfirmError("Операция не может быть выполнена");
    }

}
