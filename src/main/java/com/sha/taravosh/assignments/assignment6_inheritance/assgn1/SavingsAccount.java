package com.sha.taravosh.assignments.assignment6_inheritance.assgn1;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }


    // TODO: Create a constructor to initialize
    // accountNumber, balance and interestRate
    SavingsAccount(String account_no, double account_bal, double account_inr){
        super(account_no,account_bal);
        this.interestRate = account_inr;
    }

}
