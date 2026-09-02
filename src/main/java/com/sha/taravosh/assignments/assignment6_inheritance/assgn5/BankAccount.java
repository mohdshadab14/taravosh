package com.sha.taravosh.assignments.assignment6_inheritance.assgn5;

public class BankAccount {

    String accountNumber;
    double balance;


    // TODO: Create constructor
    BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountDetails() {

        // TODO: Print account number
        System.out.println("account number : " +accountNumber);
        // TODO: Print balance
        System.out.println("balance : "+ balance);
    }
}


