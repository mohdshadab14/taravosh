package com.sha.taravosh.assignments.assignment6_inheritance.assgn3;

public class CurrentAccount extends BankAccount {
    double minimumBalance;
    // TODO: Create constructor
    public CurrentAccount(String AccountNumber,double balance,double minimumBalance){

        super(AccountNumber,balance);
        this.minimumBalance = minimumBalance;
    }
    public void displayCurrentAccountDetails() {
        // TODO: // Call the inherited displayAccountDetails()
        displayAccountDetails();
        // TODO: // Print minimum balance
        System.out.println("minimum balance" + this.minimumBalance);
    }
}
