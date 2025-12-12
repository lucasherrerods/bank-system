package com.banksystem.model;

import static com.banksystem.model.TransactionType.WITHDRAW;

public class CurrentAccount extends Account {
    private double specialLimit;
    private double withdrawFee = 10;

    public CurrentAccount(Client client) {
        super(client);
    }

    public double getSpecialLimit() {
        return this.specialLimit;
    }

    public void setSpecialLimit(double specialLimit) {
        this.specialLimit = specialLimit;
    }

    @Override
    public void withdraw(double value) {
        double fee = (withdrawFee / 100) * value;

        if (getBalance() >= value) {
            setBalance((getBalance() - value) - fee);
            System.out.println("Saque realizado com sucesso!");
            recordTransaction(WITHDRAW, value, "Saque. (Taxa 10% = R$" + fee + ")");
        }   else if (getBalance() + specialLimit >= value + fee){
            setBalance((getBalance() - value) - fee);
            System.out.println("Saque realizado com sucesso!");
            recordTransaction(WITHDRAW, value, "Saque utilizando limite especial. (Taxa 10% = R$" + fee + ")");
        }   else {
            System.out.println("Saldo insuficiente! Não foi possível realizar o saque neste momento.");
        }
    }

    @Override
    public void showExtract() {
        System.out.println("Extrato - Conta Nº" + getAccountNumber());

        for (int i = 0; i < getHistory().size(); i++) {
            System.out.println(getHistory().get(i));
        }

        System.out.println("Saldo atual: R$" + getBalance());
        System.out.println("Limite especial: R$" + getSpecialLimit());
    }
}
