package dev.lpa;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("My bank");
        Customer john = new Customer("John Modest");
        System.out.println(john);
        ArrayList<Customer> customer = new ArrayList<>();
//
        bank.addNewCustomer(new Customer("John Doe"));
        bank.addNewCustomer(new Customer("Jane Smith"));

//        System.out.println(bank);

        bank.addTransaction(new Customer("John Doe"), 4);  // Credit
        bank.addTransaction(new Customer("John Doe"), -20.0);  // Debit
        bank.addTransaction(new Customer("Jane Smith"), 200.0); // Credit
        bank.addTransaction(new Customer("Jane Smith"), 200.0); // Debit

        System.out.println("-".repeat(30));
        bank.printDetails("John Doe");

//        bank.printDetails(customer.getFirst(0));

//        bank.printDetails(bank);
//        bank.printDetails();

//        ArrayList<Customer> customers = new ArrayList<>();
//        Customer customer1 = new Customer("Abhishek",100.00);
//        customers.add(customer1);
//        System.out.println(customers);
//        Customer customer2 = new Customer("Sagarika",1000.00d);
//        bank.addNewCustomer(customer2);
//        Customer customer3 = new Customer("Sagarika",1000.00d);
//        bank.addNewCustomer(customer3);
//        bank.addTransaction(customer2, 3000d);
    }
}
