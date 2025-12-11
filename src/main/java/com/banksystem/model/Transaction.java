package com.banksystem.model;

import com.banksystem.utils.DateFormatter;
import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private double value;
    private LocalDateTime date;
    private String description;

    public Transaction(String type, double value, String description) {
        setType(type);
        setValue(value);
        this.date = LocalDateTime.now();
        setDescription(description);
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
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
