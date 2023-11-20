package ru.dev.egoravdeev.moneytransferservice.repository;

import org.springframework.stereotype.Repository;
import ru.dev.egoravdeev.moneytransferservice.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepository {

    private List<Account> accounts;

    public AccountRepository () {
        accounts = new ArrayList<>();
        accounts.add(new Account("9090909090909090", "3134", "132"));
        accounts.add(new Account("234345345345", "24234", "24234"));
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
