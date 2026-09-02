package com.sha.taravosh.assignments.assignment6_inheritance.assgn5;

public class CurrentAccount extends BankAccount {

    double minimumBalance;

    // TODO: Create constructor
    CurrentAccount(String accountNumber, double balance, double minimumBalance){
       super(accountNumber,balance);
       this.minimumBalance = minimumBalance;
    }

    public void displayCurrentAccountDetails() {

        // TODO: Display common account details
        displayAccountDetails();
        // TODO: Display minimum balance
        System.out.println("minimum balance : "+ minimumBalance);
    }
}

