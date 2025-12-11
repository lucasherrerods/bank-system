package com.banksystem.model;

import com.banksystem.utils.DateFormatter;
import java.time.LocalDateTime;

public class Transaction {
    private TransactionType type;
    private double value;
    private LocalDateTime date;
    private String description;

    public Transaction(TransactionType type, double value, String description) {
        setType(type);
        setValue(value);
        this.date = LocalDateTime.now();
        setDescription(description);
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public TransactionType getType() {
        return this.type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{ Tipo: " + getType() + ", Valor: R$" + getValue() + ", Data: " + DateFormatter.formatted(getDate()) + ", Descrição: " + getDescription() + " }";
    }
}
