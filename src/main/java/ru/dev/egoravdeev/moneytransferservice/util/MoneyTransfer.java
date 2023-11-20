package ru.dev.egoravdeev.moneytransferservice.util;

import ru.dev.egoravdeev.moneytransferservice.exception.ConfirmError;
import ru.dev.egoravdeev.moneytransferservice.model.Account;
import ru.dev.egoravdeev.moneytransferservice.model.Transfer;

import java.math.BigDecimal;

public class MoneyTransfer {


    private synchronized void addAmmount(Account account, BigDecimal ammount) {
        account.setBalance(account.getBalance().add(ammount));
    }

    private synchronized boolean removeAmmount(Account account, BigDecimal ammount) throws ConfirmError {
        if (checkBalance(account.getBalance(), ammount)) {
            account.setBalance(account.getBalance().subtract(ammount));
            return true;
        }

        throw new ConfirmError("Недостаточно денег на счете");
    }

    public boolean transferMoney(Account accountTo, Account accountFrom, Transfer transfer) throws ConfirmError {
        if (removeAmmount(accountFrom, new BigDecimal(transfer.getAmount().getValue()))) {
            addAmmount(accountTo, new BigDecimal(transfer.getAmount().getValue()));
            return true;
        }

        throw new ConfirmError("Ошибка выполнения операции");
    }

    private boolean checkBalance(BigDecimal balance, BigDecimal ammount) {
        return balance.compareTo(ammount) >= 0;
    }
}
