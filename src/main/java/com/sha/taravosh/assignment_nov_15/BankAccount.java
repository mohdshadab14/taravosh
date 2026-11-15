package com.sha.taravosh.assignment_nov_15;

public class BankAccount {

    // TODO 1: Declare the instance variables:
    // accountNumber, accountHolder, balance

    // TODO 2: Declare static variables:
    // bankName, minimumBalance, totalAccounts, totalTransactions
    // Suggested initial values: "ABC Bank" and 500.00 for minimumBalance.

    public BankAccount(int accountNumber, String accountHolder, double initialBalance) {
        // TODO 3:
        // - Validate accountHolder is not null/blank.
        // - Validate initialBalance is at least minimumBalance.
        // - Assign all instance fields.
        // - Increment totalAccounts only after successful validation.
    }

    public void deposit(double amount) {
        // TODO 4:
        // - Reject amount <= 0 using IllegalArgumentException.
        // - Add amount to balance.
        // - Increment totalTransactions only after success.
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        // TODO 5:
        // - Reject amount <= 0 using IllegalArgumentException.
        // - Do not allow balance to fall below minimumBalance.
        // - Throw InsufficientBalanceException when funds are insufficient.
        // - Update balance and totalTransactions only after success.
    }

    public double getBalance() {
        // TODO 6: Return the current balance.
        return 0.0;
    }

    public int getAccountNumber() {
        // TODO 7: Return the account number.
        return 0;
    }

    public void displayAccountDetails() {
        // TODO 8: Print account number, holder, bank name, and balance.
    }

    public static int getTotalAccounts() {
        // TODO 9: Return totalAccounts.
        return 0;
    }

    public static int getTotalTransactions() {
        // TODO 10: Return totalTransactions.
        return 0;
    }

    public static void changeBankName(String name) {
        // TODO 11: Validate and update the shared bank name.
    }

    public static void displayBankDetails() {
        // TODO 12: Print bankName, minimumBalance,
        // totalAccounts, and totalTransactions.
    }
}
