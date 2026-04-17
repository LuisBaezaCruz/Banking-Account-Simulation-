package ui;

import Service.TransactionService;

import java.util.Scanner;

public class TransactionForm {

    private TransactionService transactionService;

    public TransactionForm(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Account ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            transactionService.deposit(id, amount);
            System.out.println("Deposit successful.");
        } catch (Exception e) {
            System.out.println("Deposit failed: " + e.getMessage());
        }
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Account ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            transactionService.withdraw(id, amount);
            System.out.println("Withdrawal successful.");
        } catch (Exception e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        }
    }

    public void transfer() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("From Account ID: ");
            String from = scanner.nextLine();

            System.out.print("To Account ID: ");
            String to = scanner.nextLine();

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            transactionService.transfer(from, to, amount);
            System.out.println("Transfer successful.");
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
    }
}