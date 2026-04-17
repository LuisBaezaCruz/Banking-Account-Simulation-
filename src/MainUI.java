import Model.AccountType;
import Model.Customer;
import Service.BankService;
import Service.InterestService;
import Service.TransactionService;
import ui.CustomerDashboard;
import ui.LoginScreen;

public class MainUI {

    public static void main(String[] args) {

        BankService bankService = new BankService();
        TransactionService transactionService = new TransactionService(bankService);
        InterestService interestService = new InterestService(bankService);

        Customer c1 = bankService.createCustomer("Alice", "alice@bank.com", "pass123");
        Customer c2 = bankService.createCustomer("Bob", "bob@bank.com", "qwerty");

        try {
            bankService.openAccount(c1.getCustomerId(), AccountType.SAVINGS);
            bankService.openAccount(c1.getCustomerId(), AccountType.CHECKING);
            bankService.openAccount(c2.getCustomerId(), AccountType.SAVINGS);
        } catch (Exception e) {
            System.out.println("Error opening accounts: " + e.getMessage());
        }

        System.out.println("Alice ID: " + c1.getCustomerId());
        System.out.println("Bob ID: " + c2.getCustomerId());

        LoginScreen loginScreen = new LoginScreen(bankService);
        Customer loggedIn = loginScreen.login();

        if (loggedIn != null) {
            CustomerDashboard dashboard = new CustomerDashboard(loggedIn, transactionService);
            dashboard.showMenu();
        } else {
            System.out.println("Exiting program.");
        }
    }
}