package com.sha.taravosh.assignments.java_oops_assignment.assignment_02_bank_account_inheritance;

public class BankAccount {

    // TODO 1:
    // Create these fields:
    String accountNumber;
    String accountHolder;
    double balance;

    // TODO 2:
    // Create a constructor to initialize all fields.
    BankAccount(String accountNumber, String accountHolder, double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // TODO 3:
    // Create a method to display the common account information.
    //
    public void displayAccount(){
        System.out.println("Account Number : " + accountNumber + "\nAccountHolder : "+accountHolder + "\nBlance : " + balance);
    }
}


