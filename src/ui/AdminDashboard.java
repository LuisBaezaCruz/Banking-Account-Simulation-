package ui;

import Model.Account;
import Model.Customer;
import Service.BankService;
import Service.InterestService;

import java.util.List;
import java.util.Scanner;

public class AdminDashboard {

    private BankService bankService;
    private InterestService interestService;

    public AdminDashboard(BankService bankService, InterestService interestService) {
        this.bankService = bankService;
        this.interestService = interestService;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== ADMIN DASHBOARD ===");
            System.out.println("1. View All Customers");
            System.out.println("2. View All Accounts");
            System.out.println("3. Apply Monthly Interest");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                List<Customer> customers = bankService.getAllCustomers();
                for (Customer customer : customers) {
                    System.out.println(customer);
                }
            } else if (choice == 2) {
                List<Account> accounts = bankService.getAllAccounts();
                for (Account account : accounts) {
                    System.out.println(account);
                }
            } else if (choice == 3) {
                interestService.applyMonthlyInterest();
                System.out.println("Monthly interest applied.");
            } else if (choice == 4) {
                System.out.println("Exiting admin dashboard...");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}