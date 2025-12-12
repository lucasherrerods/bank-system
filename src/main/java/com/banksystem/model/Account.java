package com.banksystem.model;

import com.banksystem.repositories.AccountRepository;

import java.util.ArrayList;

import static com.banksystem.model.TransactionType.*;

public abstract class Account {
    private static int counter = 1;
    private ArrayList<Transaction> history;

    private final int accountNumber;
    private Client client;
    private double balance;

    public Account(Client client) {
        this.accountNumber = counter;
        this.client = client;
        this.balance = 0;

        Account.counter += 1;
        history = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "{ Nº Conta: " + getAccountNumber() + ", Cliente: " + getClient().getName() + ", Saldo: " + getBalance() + " }";
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public Client getClient() {
        return this.client;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Transaction> getHistory() {
        return this.history;
    }

    public void deposit(double value) {
        setBalance(getBalance() + value);
        System.out.println("Depósito realizado com sucesso!");
        recordTransaction(DEPOSIT, value, "Depósito em conta.");
    }

    public abstract void withdraw(double value);

    public void transfer(int receiverAccount, double value) {
        if (getBalance() >= value) {
            Account receiver = AccountRepository.findAccount(receiverAccount);

            setBalance(getBalance() - value);
            receiver.setBalance(receiver.getBalance() + value);
            System.out.println("Transferência realizada com sucesso!");

            recordTransaction(TRANSFER_OUTPUT, value, "Transferência realizada no valor R$" + value);
            receiver.recordTransaction(TRANSFER_ENTRY, value, "Recebimento no valor de R$" + value);
        }   else {
            System.out.println("Saldo insuficiente! Não foi possível realizar a transferência.");
        }
    }

    public void recordTransaction(TransactionType type, double value, String description) {
        Transaction newTransaction = new Transaction(type, value, description);
        history.add(newTransaction);
    }

    public void showExtract() {
        System.out.println("Extrato - Conta Nº" + getAccountNumber());

        for (int i = 0; i < getHistory().size(); i++) {
            System.out.println(getHistory().get(i));
        }

        System.out.println("Saldo atual: R$" + getBalance());
    }
}
