package com.sha.taravosh.assignments.assignment6_inheritance.assgn1;

public class SavingsAccount extends BankAccount {

    double interestRate;

    // TODO: Create a constructor to initialize
    // accountNumber, balance and interestRate
    SavingsAccount(String account_no, double account_bal, double account_inr){
        this.accountNumber = account_no;
        this.balance = account_bal;
        this.interestRate = account_inr;
    }

}
