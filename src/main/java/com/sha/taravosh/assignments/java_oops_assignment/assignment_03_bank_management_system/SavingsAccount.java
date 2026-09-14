package com.sha.taravosh.assignments.java_oops_assignment.assignment_03_bank_management_system;


public class SavingsAccount extends BankAccount {

    // TODO:
    // Create:
    //
    // interestRate
    // minimumBalance
    double interestRate;
    double minimumBalance;

    // TODO:
    // Create constructor.
    //
    // Use super().
    SavingsAccount(double interestRate, double minimumBalance,String accountNumber, double balance, Customer customer){
        super(accountNumber, balance, customer);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }
}


