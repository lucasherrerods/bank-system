package com.banksystem.application;

import com.banksystem.model.Account;
import com.banksystem.model.Client;
import com.banksystem.model.CurrentAccount;
import com.banksystem.model.SavingsAccount;
import com.banksystem.service.AccountService;
import com.banksystem.service.ClientService;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("---------------------------");
            System.out.println("Sistema Bancário de Javeiro");
            System.out.println("---------------------------");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Abrir conta bancária");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir entre contas");
            System.out.println("6. Exibir extrato");
            System.out.println("7. Listar clientes");
            System.out.println("8. Listar contas");
            System.out.println("0. Sair");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    registerClient();
                    break;
                case 2:
                    openAccount();
                    break;
                case 3:
                    depositOperation();
                    break;
                case 4:
                    withdrawOperation();
                    break;
                case 5:
                    transferOperation();
                    break;
                case 6:
                    showExtractOperation();
                    break;
                case 7:
                    ClientService.listClients();
                    break;
                case 8:
                    AccountService.listAccounts();
                    break;
                case 0:
                    System.out.println("Logout efetuado.");
                    isRunning = false;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    public static void registerClient() {
        System.out.print("Digite o nome: ");
        String name = input.next();
        System.out.print("Digite o CPF: ");
        String cpf = input.next();
        System.out.print("Insira um e-mail: ");
        String email = input.next();

        Client client = new Client(name, cpf, email);
        ClientService.addClient(client);
    }

    public static void openAccount() {
        System.out.print("Insira o ID do cliente: ");
        int clientID = input.nextInt();
        Client client = ClientService.findClient(clientID);

        if (client == null) {
            menu();
        }   else {
            System.out.println("Selecione o tipo de conta: ");
            System.out.println("1. Conta corrente");
            System.out.println("2. Conta poupança");
            System.out.println("0. Cancelar ação");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    CurrentAccount currentAccount = new CurrentAccount(client);
                    AccountService.addAccount(currentAccount);
                    break;
                case 2:
                    SavingsAccount savingsAccount = new SavingsAccount(client);
                    AccountService.addAccount(savingsAccount);
                    break;
                case 0:
                    System.out.println("Cancelando ação...");
                    menu();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    public static void depositOperation() {
        System.out.print("Insira o número da conta: ");
        int accountNumber = input.nextInt();
        Account account = AccountService.findAccount(accountNumber);

        if (account == null) {
            menu();
        }   else {
            System.out.println("Informe o valor que deseja depositar: ");
            double value = input.nextDouble();
            account.deposit(value);
        }
    }

    public static void withdrawOperation() {
        System.out.print("Insira o número da conta: ");
        int accountNumber = input.nextInt();
        Account account = AccountService.findAccount(accountNumber);

        if (account == null) {
            menu();
        }   else {
            System.out.println("Informe o valor que deseja sacar: ");
            double value = input.nextDouble();
            account.withdraw(value);
        }
    }

    public static void transferOperation() {
        System.out.print("Insira o número da conta do remetente: ");
        int senderNumber = input.nextInt();
        Account account = AccountService.findAccount(senderNumber);

        if (account == null) {
            menu();
        }   else {
            System.out.print("Insira o número da conta do destinatário: ");
            int receiverNumber = input.nextInt();
            System.out.println("Informe o valor que deseja transferir: ");
            double value = input.nextDouble();

            account.transfer(receiverNumber, value);
        }
    }

    public static void showExtractOperation() {
        System.out.print("Insira o número da conta: ");
        int accountNumber = input.nextInt();
        Account account = AccountService.findAccount(accountNumber);

        if (account == null) {
            menu();
        }   else {
            account.showExtract();
        }
    }
}
