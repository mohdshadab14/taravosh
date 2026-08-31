package com.sha.taravosh.assignments.assignment6_inheritance.assgn1;

public class SavingsAccount extends BankAccount {

    //private double interestRate;
    private static final double interestRate = 5.5; //REMOVE FINAL TO MAKE IT CHANGE
    private String location;


    public static double getInterestRate() {
        //interestRate = 10; -- values cannot be changed once defined as FINAL
        return interestRate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // TODO: Create a constructor to initialize
    // accountNumber, balance and interestRate
    SavingsAccount(String account_no, double account_bal){
        super(account_no,account_bal);
    }

}
