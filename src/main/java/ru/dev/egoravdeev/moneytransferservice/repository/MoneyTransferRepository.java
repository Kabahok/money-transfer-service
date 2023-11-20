package ru.dev.egoravdeev.moneytransferservice.repository;

import ru.dev.egoravdeev.moneytransferservice.exception.ConfirmError;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;

import java.util.Optional;

public interface MoneyTransferRepository {
    void addNewTransfer(Transfer transfer);

    Optional<Transfer> getTransfer(String operationId);

    Optional<Transfer> deleteTransfer(String operationId) throws ConfirmError;

}
