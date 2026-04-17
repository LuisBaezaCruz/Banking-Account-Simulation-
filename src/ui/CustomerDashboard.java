package ui;

import Model.Account;
import Model.Customer;
import Service.TransactionService;

import java.util.List;
import java.util.Scanner;

public class CustomerDashboard {

    private Customer customer;
    private TransactionService transactionService;

    public CustomerDashboard(Customer customer, TransactionService transactionService) {
        this.customer = customer;
        this.transactionService = transactionService;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        TransactionForm form = new TransactionForm(transactionService);
        TransactionHistoryView historyView = new TransactionHistoryView(transactionService);

        while (true) {
            System.out.println("\n=== CUSTOMER DASHBOARD ===");
            System.out.println("1. View Accounts");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                viewAccounts();
            } else if (choice == 2) {
                form.deposit();
            } else if (choice == 3) {
                form.withdraw();
            } else if (choice == 4) {
                form.transfer();
            } else if (choice == 5) {
                historyView.showHistory();
            } else if (choice == 6) {
                System.out.println("Logging out...");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private void viewAccounts() {
        List<Account> accounts = customer.getAccounts();

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("\nYour Accounts:");
            for (Account account : accounts) {
                System.out.println(account);
            }
        }
    }
}