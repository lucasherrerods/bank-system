package com.banksystem.model;

public class Client {
    private static int counter = 1;
    private int id;
    private String name;
    private String cpf;
    private String email;

    public Client(String name, String cpf) {
        this.id = counter;
        setName(name);
        setCpf(cpf);
        Client.counter += 1;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{ ID: " + getId() + ", Nome: " + getName() + ", CPF: " + getCpf() + ", E-mail: " + getEmail() + " }";
    }
}
