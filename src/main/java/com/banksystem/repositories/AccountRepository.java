package com.banksystem.repositories;

import com.banksystem.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private static final List<Account> accounts = new ArrayList<>();

    public static void addAccount(Account account) {
        accounts.add(account);
    }

    public static Account findAccount(int accountNumber) {
        Account account = null;
        if (!listAccounts().isEmpty()) {
            for (Account c : listAccounts()) {
                if (c.getAccountNumber() == accountNumber) {
                    account = c;
                }
            }
        }   else {
            return null;
        }

        return account;
    }

    public static List<Account> listAccounts() {
        return accounts;
    }

    public static Account removeAccount(int accountNumber) {
        Account account = findAccount(accountNumber);

        if (account == null) {
            return null;
        }   else {
            accounts.remove(account);
        }

        return account;
    }
}
