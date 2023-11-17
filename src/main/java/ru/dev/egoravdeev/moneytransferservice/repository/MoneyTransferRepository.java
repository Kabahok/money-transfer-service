package ru.dev.egoravdeev.moneytransferservice.repository;

import ru.dev.egoravdeev.moneytransferservice.model.Transfer;

import java.util.Optional;

public interface MoneyTransferRepository {
    void addNewTransfer(Transfer transfer);

    Optional<Transfer> getTransfer();
}
