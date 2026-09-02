package com.sha.taravosh.assignments.assignment6_inheritance.assgn5;

public class SavingsAccount extends BankAccount {

    double interestRate;

    // TODO: Create constructor
SavingsAccount(String accountNumber, double balance, double interestRate){
    super(accountNumber, balance);
    this.interestRate = interestRate;
}

    public void displaySavingsDetails() {

        // TODO: Display common account details
        displayAccountDetails();
        // TODO: Display interest rate
        System.out.println("interestRate : "+ interestRate);
    }
}
