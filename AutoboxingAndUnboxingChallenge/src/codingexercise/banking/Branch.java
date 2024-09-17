package codingexercise.banking;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialTransaction) {
        var customer = findCustomer(customerName);
        if(customer == null) {
//            customers.add(customer);
//            return true;
            return customers.add(new Customer(customerName, initialTransaction));
        }

        return false;
    }

    public boolean addCustomerTransaction(String customerName, double transaction) {
        var customer = findCustomer(customerName);
        if(customer != null) {
            customer.getTransactions().add(transaction);
            return true;
        }

        return false;
    }

    private Customer findCustomer(String customer) {
        for(var customerSearch : customers) {
            if(customerSearch.getName().equalsIgnoreCase(customer)) {
                return customerSearch;
            }
        }

        return null;
    }
}
