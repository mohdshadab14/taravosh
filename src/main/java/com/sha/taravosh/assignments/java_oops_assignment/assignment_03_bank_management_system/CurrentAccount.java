package com.sha.taravosh.assignments.java_oops_assignment.assignment_03_bank_management_system;


public class CurrentAccount extends BankAccount {

    // TODO:
    // Create:
    //
    // businessName
    // overdraftLimit
    String businessName;
    double overdraftLimit;

    // TODO:
    // Create constructor.
    //
    // Use super().
    CurrentAccount(String businessName, double overdraftLimit, String accountNumber, double balance, Customer customer){
        super(accountNumber,balance,customer);
        this.businessName = businessName;
        this.overdraftLimit = overdraftLimit;
    }

}
