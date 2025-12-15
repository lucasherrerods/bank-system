package com.banksystem.service;

import com.banksystem.model.Account;
import com.banksystem.model.Client;
import com.banksystem.repositories.AccountRepository;
import com.banksystem.repositories.ClientRepository;

import java.util.List;


public class AccountService {
    public static boolean addAccount(Account account) {
        for (Account c : AccountRepository.listAccounts()) {
            if (c.getAccountNumber() == account.getAccountNumber()) {
                System.out.println("Já existe uma conta cadastrada com esse número!");
                return false;
            }
        }

        AccountRepository.addAccount(account);
        account.setCounter();
        System.out.println("Conta adicionada com sucesso.");
        System.out.println(account.toString());
        return true;
    }


    public static Account findAccount(int accountNumber) {
        Account account = AccountRepository.findAccount(accountNumber);

        if (account == null) {
            System.out.println("Conta não localizada.");
        }   else {
            System.out.println("Informações da conta:");
            System.out.println(account);
        }
        return account;
    }

    public static void listAccounts() {
        List<Account> accounts = AccountRepository.listAccounts();

        if (accounts.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        }   else {
            System.out.println("Lista de contas:");
            System.out.println("---------------------------");

            for (Account a : accounts) {
                System.out.println(a.toString());
            }
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