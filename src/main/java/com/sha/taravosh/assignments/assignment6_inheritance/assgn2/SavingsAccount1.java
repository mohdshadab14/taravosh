package com.sha.taravosh.assignments.assignment6_inheritance.assgn2;

public class SavingsAccount1 extends BankAccount1 {

    double interestRate;

    // TODO: Create constructor
    public SavingsAccount1(String accountNumber, double balance, double interestRate){
        super(accountNumber, balance);
        this.interestRate = interestRate;

    }

}
