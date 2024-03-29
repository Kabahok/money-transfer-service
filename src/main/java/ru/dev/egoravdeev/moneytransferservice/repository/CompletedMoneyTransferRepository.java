package ru.dev.egoravdeev.moneytransferservice.repository;

import org.springframework.stereotype.Repository;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompletedMoneyTransferRepository {
    private final List<Transfer> transfers;

    public CompletedMoneyTransferRepository() {
        this.transfers = new ArrayList<>();
    }

    public void addTransfer(Transfer transfer) {
        transfers.add(transfer);
    }
}
