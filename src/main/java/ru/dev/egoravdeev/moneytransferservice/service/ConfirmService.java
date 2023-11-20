package ru.dev.egoravdeev.moneytransferservice.service;

import org.springframework.stereotype.Service;
import ru.dev.egoravdeev.moneytransferservice.constants.StatusOfTransfer;
import ru.dev.egoravdeev.moneytransferservice.exception.ConfirmError;
import ru.dev.egoravdeev.moneytransferservice.exception.ErrorInputData;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;
import ru.dev.egoravdeev.moneytransferservice.repository.AccountRepository;
import ru.dev.egoravdeev.moneytransferservice.repository.CompletedMoneyTransferRepository;
import ru.dev.egoravdeev.moneytransferservice.repository.MoneyTransferRepository;
import ru.dev.egoravdeev.moneytransferservice.util.MoneyTransfer;

@Service
public class ConfirmService {

    private final MoneyTransferRepository moneyTransferRepository;
    private final AccountRepository accountRepository;
    private final MoneyTransfer moneyTransfer;
    private final CompletedMoneyTransferRepository completedMoneyTransferRepository;

    public ConfirmService(MoneyTransferRepository moneyTransferRepository, AccountRepository accountRepository, MoneyTransfer moneyTransfer, CompletedMoneyTransferRepository completedMoneyTransferRepository) {
        this.moneyTransferRepository = moneyTransferRepository;
        this.accountRepository = accountRepository;
        this.moneyTransfer = moneyTransfer;
        this.completedMoneyTransferRepository = completedMoneyTransferRepository;
    }

    public Transfer confirmOperation(String operationId, String code) throws ConfirmError, ErrorInputData {
        final var transfer = moneyTransferRepository.getTransfer(operationId);

        if (transfer.isPresent() && transfer.get().getCode().equals(code)) {

            final var accountFrom = accountRepository.getAccountForNumber(transfer.get().getCardNumberFrom());
            final var accountTo = accountRepository.getAccountForNumber(transfer.get().getCardNumberTo());

            if (accountTo.isPresent() && accountFrom.isPresent()) {
                if (moneyTransfer.transferMoney(accountTo.get(), accountFrom.get(), transfer.get())) {
                    final var completedTransfer = moneyTransferRepository.deleteTransfer(operationId).get();

                    completedTransfer.setStatus(StatusOfTransfer.COMPLETE);

                    completedMoneyTransferRepository.addTransfer(completedTransfer);


                    return completedTransfer;
                }
                throw new ConfirmError("Операция не может быть выполнена");

            }

            throw new ErrorInputData("Некорректные данные");

        }

        throw new ConfirmError("Операция не может быть выполнена");
    }

}
