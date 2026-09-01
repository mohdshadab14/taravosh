package com.sha.taravosh.assignments.assignment6_inheritance.assgn3;

public class SavingsAccount extends BankAccount {
    double interestRate;
    // TODO: Create constructor
    SavingsAccount(String AccountNumber, double balance, double interestRate){
        super(AccountNumber,balance);
        this.interestRate = interestRate;
    }
    public void displaySavingsDetails() {
        // TODO:
        // Call the inherited displayAccountDetails() method
        displayAccountDetails();
        // TODO:
        // Print interest rate
        System.out.println("Interest Rate : "+ interestRate);
    }
}

