package com.banksystem.repositories;

import com.banksystem.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private static final List<Client> clients = new ArrayList<>();

    public static void addClient(Client client) {
        clients.add(client);
    }

    public static Client findClient(int clientID) {
        Client client = null;
        if (!listClients().isEmpty()) {
            for (Client c : listClients()) {
                if (c.getId() == clientID) {
                    client = c;
                }
            }
        }   else {
            return null;
        }

        return client;
    }

    public static List<Client> listClients() {
        return clients;
    }

    public static Client removeClient(int clientID) {
        Client client = findClient(clientID);

        if (client == null) {
            return null;
        }   else {
            clients.remove(client);
        }

        return client;
    }
}
