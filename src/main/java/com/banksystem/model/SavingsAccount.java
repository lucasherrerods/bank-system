package com.banksystem.model;

import static com.banksystem.model.TransactionType.WITHDRAW;

public class SavingsAccount extends Account {
    private static double incomeMonth = 5;
    private static int minWithdraw = 20;

    public SavingsAccount(Client client) {
        super(client);
    }

    public void income() {
        double apllyIncome = (incomeMonth / 100) * getBalance();
        setBalance(getBalance() + apllyIncome);
        System.out.println("Rendimento aplicado com sucesso! (0,5% ao mês)");
    }

    @Override
    public void withdraw(double value) {
        if (getBalance() >= value && value >= minWithdraw) {
            setBalance(getBalance() - value);
            System.out.println("Saque realizado com sucesso!");
            recordTransaction(WITHDRAW, value, "Saque em Conta Poupança.");
        }   else {
            System.out.println("Saldo insuficiente! Não foi possível realizar o saque neste momento. (Mínimo R$20,00)");
        }
    }
}
