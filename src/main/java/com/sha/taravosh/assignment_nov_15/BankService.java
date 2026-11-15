package com.sha.taravosh.assignment_nov_15;

import java.util.ArrayList;
import java.util.List;

public class BankService {

    private final List<BankAccount> accounts = new ArrayList<>();

    public void createAccount(int accountNumber, String holder, double initialBalance) {
        // TODO 15:
        // - Check whether accountNumber already exists.
        // - If it exists, throw IllegalArgumentException.
        // - Otherwise create and store a BankAccount.
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        // TODO 16: Search the list and return the matching account.
        // If no account is found, throw AccountNotFoundException.
        return null;
    }

    public void deposit(int accountNumber, double amount)
            throws AccountNotFoundException {
        // TODO 17: Find account and call its deposit method.
    }

    public void withdraw(int accountNumber, double amount)
            throws AccountNotFoundException, InsufficientBalanceException {
        // TODO 18: Find account and call its withdraw method.
    }

    public void displayAccount(int accountNumber) throws AccountNotFoundException {
        // TODO 19: Find account and display its details.
    }
}
