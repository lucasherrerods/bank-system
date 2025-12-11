package com.banksystem.application;

import com.banksystem.model.Client;
import com.banksystem.model.Transaction;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static Transaction newTransaction;

    public static void main(String[] args) {
        //Teste de instância da classe

        System.out.print("Digite o tipo: ");
        String type = input.next();
        System.out.print("Digite o valor: ");
        double value = input.nextDouble();
        System.out.print("Digite a descrição: ");
        String description = input.next();

        newTransaction = new Transaction(type, value, description);

        System.out.println("Nova transação cadastrada com sucesso!");
        System.out.println(newTransaction.toString());
    }
}
