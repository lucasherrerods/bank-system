package com.banksystem.repositories;

import com.banksystem.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private static final List<Account> accounts = new ArrayList<>();

    public static boolean addAccount(Account account) {
        for (Account c : accounts) {
            if (c.getAccountNumber() == account.getAccountNumber()){
                System.out.println("Já existe uma conta cadastrada com esse número!");
                return false;
            }
        }
        return accounts.add(account);
    }

    public static Account findAccount(int accountNumber) {
        Account account = null;
        if (!accounts.isEmpty()) {
            for (Account c : accounts) {
                if (c.getAccountNumber() == accountNumber) {
                    account = c;
                }
            }
        }   else {
            System.out.println("Conta não encontrada.");
        }

        return account;
    }

    public List<Account> listAccounts() {
        return accounts;
    }

    public void removeAccount(int accountNumber) {
        accounts.remove(accountNumber - 1);
        System.out.println("Conta removida com sucesso.");
    }
}
