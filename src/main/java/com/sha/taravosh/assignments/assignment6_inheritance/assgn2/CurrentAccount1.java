package com.sha.taravosh.assignments.assignment6_inheritance.assgn2;



public class CurrentAccount1 extends BankAccount1 {

    double minimumBalance;

    // TODO: Create constructor
    // Initialize accountNumber,
    // balance and minimumBalance
    public CurrentAccount1(String accountNumber, double balance, double minimumBalance){
        super(accountNumber, balance);
     this.minimumBalance = minimumBalance;
    }

}