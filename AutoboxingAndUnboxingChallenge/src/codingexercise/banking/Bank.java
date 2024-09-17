package codingexercise.banking;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        var branch = findBranch(branchName);
        if(branch == null) {
            return branches.add(new Branch(branchName));
//            return true;
        }

        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        var branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName, initialTransaction);
        }

        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        var branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(customerName, transaction);
        }

        return false;
    }

    private Branch findBranch(String branchName) {
        for(var branch : branches) {
            if(branch.getName().equalsIgnoreCase(branchName)) {
//                branches.add(branch);
                return branch;
            }
        }

        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        var branch = findBranch(branchName);
        if(branch == null) {
            return false;
        }

        System.out.println("Customer details for branch " + branch.getName());

        // added this entire nested for loops
        ArrayList<Customer> branchCustomers = branch.getCustomers();
        for(int i = 0; i < branchCustomers.size(); i++) {
            Customer branchCustomer = branchCustomers.get(i);
            System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");

            if(showTransactions) {
                System.out.println("Transactions");
                ArrayList<Double> transactions = branchCustomer.getTransactions();
                for(int j = 0; j < transactions.size(); j++) {
                    System.out.println("[" + (j + 1) + "] Amount" + transactions.get(j));
                }
            }
        }
        return true;
    }
}