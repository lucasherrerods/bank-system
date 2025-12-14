package com.banksystem.service;

import com.banksystem.model.Client;
import com.banksystem.repositories.ClientRepository;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {
    // Regex comum para validação de e-mail
    private static final String regexEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern emailPattern = Pattern.compile(regexEmail);


    public static boolean emailValidate(String email) {
        if (email.trim().isEmpty()) {
            return false;
        }
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    public boolean addClient(Client client) {
        for (Client c : ClientRepository.listClients()) {
            if (c.getCpf().equals(client.getCpf())){
                System.out.println("Já existe um cliente cadastrado com esse CPF!");
                return false;
            }
        }

        if (client.getName().trim().isEmpty()) {
            System.out.println("Não foi possível cadastrar o cliente! (Nome em branco)");
            return false;
        }   else if (!emailValidate(client.getEmail())) {
            System.out.println("Não foi possível cadastrar o cliente! (E-mail inválido)");
            return false;
        }   else {
            ClientRepository.addClient(client);
            System.out.println("Cliente adicionado com sucesso.");
            return true;
        }
    }

    public void findClient(int clientID) {
        Client client = ClientRepository.findClient(clientID);

        if (client == null) {
            System.out.println("Cliente não localizado.");
        }   else {
            System.out.println(client);
        }
    }

    public void removeClient(int clientID) {
        Client client = ClientRepository.removeClient(clientID);

        if (client == null) {
            System.out.println("Cliente não encontrado! Não foi possível realizar a exclusão.");
        }   else {
            System.out.println("Cliente removido com sucesso.");
        }
    }
}
