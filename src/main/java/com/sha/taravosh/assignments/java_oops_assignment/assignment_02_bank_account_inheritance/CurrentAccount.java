package com.sha.taravosh.assignments.java_oops_assignment.assignment_02_bank_account_inheritance;


public class CurrentAccount extends BankAccount {

    // TODO 1:
    // Create:
    // businessName
    // overdraftLimit
    String businessName;
    double overdraftLimit;

    // TODO 2:
    // Create a constructor.
    // Use super() to initialize the
    // parent class fields.
    CurrentAccount(String accountNumber, String accountHolder, double balance, String businessName, double overdraftLimit){
        super(accountNumber,accountHolder,balance);
        this.businessName = businessName;
        this.overdraftLimit = overdraftLimit;
    }

    // TODO 3:
    // Create a method to display CurrentAccount information.
    public void displayCurrentAccountDetails(){
        displayAccount();
        System.out.println("Business Name : " + businessName + "\nOverdraft Limit : " + overdraftLimit);
    }
}

