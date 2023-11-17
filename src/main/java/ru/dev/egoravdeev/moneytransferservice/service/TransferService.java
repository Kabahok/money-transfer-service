package ru.dev.egoravdeev.moneytransferservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dev.egoravdeev.moneytransferservice.constants.StatusOfTransfer;
import ru.dev.egoravdeev.moneytransferservice.exception.ErrorInputData;
import ru.dev.egoravdeev.moneytransferservice.model.DataOfTransfer;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;
import ru.dev.egoravdeev.moneytransferservice.repository.AccountRepository;
import ru.dev.egoravdeev.moneytransferservice.repository.MoneyTransferRepository;
import ru.dev.egoravdeev.moneytransferservice.util.GenerateCode;
import ru.dev.egoravdeev.moneytransferservice.util.GenerateId;


@Service
public class TransferService {

    private final AccountRepository accountRepository;
    private final TransferBuilder transferBuilder;
    private final GenerateCode generateCode;
    private final GenerateId generateId;
    private final MoneyTransferRepository moneyTransferRepository;

    public TransferService (
            AccountRepository accountRepository,
            TransferBuilder transferBuilder,
            GenerateId generateId,
            GenerateCode generateCode,
            MoneyTransferRepository moneyTransferRepository) {
        this.accountRepository = accountRepository;
        this.transferBuilder = transferBuilder;
        this.generateCode = generateCode;
        this.generateId = generateId;
        this.moneyTransferRepository = moneyTransferRepository;
    }

    public Transfer createTransfer(DataOfTransfer dataOfTransfer) throws ErrorInputData {
        final var accountTo = accountRepository.getAccountForNumber(dataOfTransfer.getCardToNumber());
        final var accountFrom = accountRepository.getAccountForNumber(dataOfTransfer.getCardFromNumber());

        if (!accountTo.isEmpty() && !accountFrom.isEmpty()) {
            Transfer transfer = transferBuilder.addCardNumberFrom(accountFrom.get().getNumber())
                    .addCardNumberTo(accountTo.get().getNumber())
                    .addCode(generateCode.getCode())
                    .addOperationId(generateId.getId())
                    .addAmount(dataOfTransfer.getAmount())
                    .addStatus(StatusOfTransfer.NEW)
                    .build();

            moneyTransferRepository.addNewTransfer(transfer);
            System.out.println(transfer);

            return transfer;
        }

        throw new ErrorInputData("Введены некорректные данные");
    }
}
