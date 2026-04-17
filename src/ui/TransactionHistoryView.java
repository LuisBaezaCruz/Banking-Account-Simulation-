package ui;

import Service.TransactionService;

import java.util.List;
import java.util.Scanner;

public class TransactionHistoryView {

    private TransactionService transactionService;

    public TransactionHistoryView(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public void showHistory() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter Account ID: ");
            String accountId = scanner.nextLine();

            List<?> history = transactionService.getHistory(accountId);

            System.out.println("\n=== TRANSACTION HISTORY ===");

            if (history.isEmpty()) {
                System.out.println("No transactions found.");
            } else {
                for (Object transaction : history) {
                    System.out.println(transaction);
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving history: " + e.getMessage());
        }
    }
}