package com.sha.taravosh.oops_assignment.bank_account_management;

public class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 5000.0;

    public CurrentAccount(int accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        // TODO: Allow withdrawal up to the overdraft limit
        return false;
    }
}
