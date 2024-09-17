package codingexercise.banking;

import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        Bank bank = new Bank("National Australia Bank");
//
//        bank.addBranch("Adelaide");
//
//        bank.addCustomer("Adelaide", "Tim", 50.05);
//        bank.addCustomer("Adelaide", "Mike", 175.34);
//        bank.addCustomer("Adelaide", "Percy", 220.12);
//
//        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
//        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
//        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);
//
//        bank.listCustomers("Adelaide", true);
//    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("National Australia Bank");

        boolean quit = false;
        while (!quit) {
            System.out.print("""
                    Available actions (select number)
                    0 - Quit
                    1 - Add branch
                    2 - Add customer
                    3 - Add customer transaction
                    4 - List customer
                    Your Choice:\s""");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter branch name:");
                    String branchName = scanner.nextLine();
                    if (bank.addBranch(branchName)) {
                        System.out.println("Branch added.");
                    } else {
                        System.out.println("Branch already exists.");
                    }
                    break;
                case 2:
                    System.out.println("Enter branch name:");
                    branchName = scanner.nextLine();
                    System.out.println("Enter customer name:");
                    String customerName = scanner.nextLine();
                    System.out.println("Enter initial transaction:");
                    double initialTransaction = scanner.nextDouble();
                    if (bank.addCustomer(branchName, customerName, initialTransaction)) {
                        System.out.println("Customer added.");
                    } else {
                        System.out.println("Branch not found or customer already exists.");
                    }
                    break;
                case 3:
                    System.out.println("Enter branch name:");
                    branchName = scanner.nextLine();
                    System.out.println("Enter customer name:");
                    customerName = scanner.nextLine();
                    System.out.println("Enter transaction amount:");
                    double transaction = scanner.nextDouble();
                    if (bank.addCustomerTransaction(branchName, customerName, transaction)) {
                        System.out.println("Transaction added.");
                    } else {
                        System.out.println("Branch or customer not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter branch name:");
                    branchName = scanner.nextLine();
                    System.out.println("Do you want to print transactions? (true/false)");
                    boolean printTransactions = scanner.nextBoolean();
                    if (!bank.listCustomers(branchName, printTransactions)) {
                        System.out.println("Branch not found.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
