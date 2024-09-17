package dev.lpa;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addNewCustomer(Customer customer) {
        for(Customer custom : customers) {
            if(custom.getName().equalsIgnoreCase(customer.getName())) {
                System.out.println("Customer already exists");
                return;
            }
        }

        customers.add(customer);
        System.out.println("Customer added " + customers);
    }

    public void addTransaction(Customer customerName, double amount) {
        for(Customer custom : customers) {
            if(custom.getName().equalsIgnoreCase(customerName.getName())) {
                custom.addTransaction(amount);
                System.out.println("transaction added : " + amount);
                return;
            }
        }

        System.out.println("Customer not found: " + customerName);
    }

    public void printDetails(String customerName) {
        for(var custom : customers) {
            if(custom.getName().equalsIgnoreCase(customerName)) {
                System.out.println("Customer name: " + custom.getName() );
                System.out.println("Transaction: " + custom.getTransaction());
                return;
            }
        }

        System.out.println("Customer not found: " + customerName);
    }
}
