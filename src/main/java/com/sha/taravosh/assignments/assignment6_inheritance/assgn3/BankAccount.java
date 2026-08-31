package com.sha.taravosh.assignments.assignment6_inheritance.assgn3;

public class BankAccount {

    String accountNumber;
    double balance;
//if parameters are given in the Class irrespective of Parent or sub class => constructor is required
    // TODO: Create constructor
    BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountDetails() {

        // TODO:
        // Print account number
        System.out.println("account number" + accountNumber);
        // Print balance
        System.out.println("balance" + balance);
    }
}