package com.sha.taravosh.oops_assignment.bank_account_management;

public class SavingsAccount extends BankAccount {
    private static final double MINIMUM_BALANCE = 1000.0;

    public SavingsAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        // TODO: Allow withdrawal only if minimum balance is maintained
        return false;
    }
}
