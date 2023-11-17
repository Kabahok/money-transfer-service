package ru.dev.egoravdeev.moneytransferservice.repository;

import ru.dev.egoravdeev.moneytransferservice.model.Account;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {

    private List<Account> accounts;

    public AccountRepository () {
        accounts = new ArrayList<>();
    }

    public Optional<Account> getAccountForNumber(String number) {
        for (Account account : accounts) {
            if (account.getNumber().equals(number)) {
                return Optional.of(account);
            }
        }

        return Optional.empty();
    }

}
