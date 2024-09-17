package timssolution;

import java.util.ArrayList;
import java.util.Scanner;

record Customer(String name, ArrayList<Double> transactions) {
    public Customer(String name, double initialDeposit) {
        this(name.toUpperCase(), new ArrayList<>(500));
        transactions.add(initialDeposit);
    }
}
public class Main {
    public static void main(String[] args) {
//        Customer bob = new Customer("Bobs", 1000.00);
//        System.out.println(bob);
//
//        Bank bank = new Bank("Chase");
//        bank.addNewCustomer("Jane A", 500.0);
//        System.out.println(bank);
//
//        bank.addTransaction("Jane A", -10.25);
//        bank.addTransaction("Jane A", -75.01);
//        bank.printStatement("Jane A");
//
//        bank.addNewCustomer("Bob S", 25);
//        bank.addTransaction("Bob S", 100);
//        bank.printStatement("Bob S");

        Bank bank = new Bank("Chase");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new customer");
            System.out.println("2. Add transaction");
            System.out.println("3. Print customer statement");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial deposit: ");
                    double initialDeposit = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    bank.addNewCustomer(name, initialDeposit);
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter transaction amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    bank.addTransaction(customerName, amount);
                    break;
                case 3:
                    System.out.print("Enter customer name: ");
                    String nameToPrint = scanner.nextLine();
                    bank.printStatement(nameToPrint);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    private Customer getCustomer(String customerName) {
        for(var customer : customers) {
            if(customer.name().equalsIgnoreCase(customerName)) {
                return customer;
            }
        }

        System.out.printf("Customer (%s) wasn't found %n", customerName);
        return null;
    }

    public void addNewCustomer(String customerName, double initialDeposit) {
        if(getCustomer(customerName) == null) {
            Customer customer = new Customer(customerName, initialDeposit);
            customers.add(customer);
            System.out.println("New Customer added: " + customer);
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    public void addTransaction(String name, double transactionAmount) {
        Customer customer = getCustomer(name);
        if(customer != null) {
            customer.transactions().add(transactionAmount);
        }
    }

    public void printStatement(String customerName) {
        Customer customer = getCustomer(customerName);
        if(customer == null) {
            return;
        }

        System.out.println("-".repeat(30));
        System.out.println("Customer Name: " + customer.name());
        System.out.println("Transactions:");
        for(double d : customer.transactions()) {   //unboxing
            System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit" : "credit");
        }
    }
}
