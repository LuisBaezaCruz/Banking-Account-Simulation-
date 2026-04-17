package ui;

import Exceptions.AccountNotFoundException;
import Model.Customer;
import Service.BankService;

import java.util.Scanner;

public class LoginScreen {

    private final BankService bankService;

    public LoginScreen(BankService bankService) {
        this.bankService = bankService;
    }

    public Customer login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== LOGIN ===");

        System.out.print("Enter Customer ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        boolean success = bankService.authenticate(id, password);

        if (success) {
            System.out.println("Login successful.");
            try {
                return bankService.findCustomer(id);
            } catch (AccountNotFoundException e) {
                System.out.println("Customer not found.");
                return null;
            }
        } else {
            System.out.println("Login failed.");
            return null;
        }
    }
}