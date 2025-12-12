package com.banksystem.repositories;

import com.banksystem.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientRepository {
    // Regex comum para validação de e-mail
    private static final String regexEmail = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern emailPattern = Pattern.compile(regexEmail);
    private static final List<Client> clients = new ArrayList<>();


    public static boolean emailValidate(String email) {
        if (email.trim().isEmpty()) {
            return false;
        }
        Matcher matcher = emailPattern.matcher(email);
        return matcher.matches();
    }

    public boolean addClient(Client client) {

        for (Client c : clients) {
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
        }

        return clients.add(client);
    }

    public static Client findClient(int clientID) {
        Client client = null;
        if (!clients.isEmpty()) {
            for (Client c : clients) {
                if (c.getId() == clientID) {
                    client = c;
                }
            }
        }   else {
            System.out.println("Cliente não encontrado.");
        }

        return client;
    }

    public List<Client> listClients() {
        return clients;
    }

    public void removeClient(int clientID) {
        clients.remove(clientID - 1);
        System.out.println("Cliente removido com sucesso.");
    }
}
