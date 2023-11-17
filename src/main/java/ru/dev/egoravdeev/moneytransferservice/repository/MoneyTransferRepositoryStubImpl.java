package ru.dev.egoravdeev.moneytransferservice.repository;

import org.springframework.stereotype.Repository;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class MoneyTransferRepositoryStubImpl implements MoneyTransferRepository {

    private List<Transfer> transfers;

    public MoneyTransferRepositoryStubImpl() {
        transfers = new ArrayList<>();
    }

    @Override
    public void addNewTransfer(Transfer transfer) {

    }

    @Override
    public Optional<Transfer> getTransfer() {
        return null;
    }
}
