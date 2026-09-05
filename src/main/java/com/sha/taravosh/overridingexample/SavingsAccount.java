package com.sha.taravosh.overridingexample;

class SavingsAccount extends BankAccount {

    double interestRate = 4.0;

    SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    void calculateInterest() {
        double interest = balance * interestRate / 100;

        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Interest Earned: " + interest);
    }
}

