package ru.job4j.bank;

public class Account {
    public final static Account EMPTY = new Account();
    private double values;
    private String requisites;

    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    private Account() {

    }

    public double getValue() {
        return values;
    }

    public String getRequisites() {
        return requisites;
    }

    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount <= this.values && destination != null
                && this.EMPTY != this && destination.EMPTY != destination) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }
}