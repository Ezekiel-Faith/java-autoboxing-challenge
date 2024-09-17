package dev.lpa;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transaction;

    public Customer(String name) {
        this.name = name;
        this.transaction = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }

    public void addTransaction(double amount) {
        transaction.add(amount);
//        System.out.println(transaction);
    }

    @Override
    public String toString() {
        return getName() + " " + getTransaction();
    }
}
