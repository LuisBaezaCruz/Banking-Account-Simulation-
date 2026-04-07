package interfaces;

/*
 * Transactable.java
 * A contract that says: if you implement me, you must support deposit() and withdraw().
 * Account types like SavingsAccount and CheckingAccount implement this interface.
 */
import exceptions.InvalidAmountException;
import exceptions.InsufficientFundsException;

public interface Transactable {
    void deposit(double amount) throws InvalidAmountException;
    void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException;
}
