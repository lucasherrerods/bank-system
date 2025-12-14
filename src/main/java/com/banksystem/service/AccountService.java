package com.banksystem.service;

import com.banksystem.model.Account;
import com.banksystem.repositories.AccountRepository;


public class AccountService {
    public boolean addAccount(Account account) {
        for (Account c : AccountRepository.listAccounts()) {
            if (c.getAccountNumber() == account.getAccountNumber()) {
                System.out.println("Já existe uma conta cadastrada com esse número!");
                return false;
            }
        }

        AccountRepository.addAccount(account);
        System.out.println("Conta adicionada com sucesso.");
        return true;
    }


    public void findAccount(int accountNumber) {
        Account account = AccountRepository.findAccount(accountNumber);

        if (account == null) {
            System.out.println("Conta não localizada.");
        }   else {
            System.out.println(account);
        }
    }

    public void removeAccount(int accountNumber) {
        Account account = AccountRepository.removeAccount(accountNumber);

        if (account == null) {
            System.out.println("Conta não encontrado! Não foi possível realizar a exclusão.");
        }   else {
            System.out.println("Conta removida com sucesso.");
        }
    }
}