package com.sha.taravosh.overridingexample;

class CurrentAccount extends BankAccount {

    CurrentAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    void calculateInterest() {
        System.out.println("Current account does not earn interest.");
    }
}
