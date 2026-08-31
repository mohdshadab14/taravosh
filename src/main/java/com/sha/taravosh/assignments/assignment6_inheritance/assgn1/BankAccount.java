package com.sha.taravosh.assignments.assignment6_inheritance.assgn1;

public class BankAccount {

    private String accountNumber;
    private double balance;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if(accountNumber.length()>15){
            this.accountNumber = accountNumber;
        }else{
            throw new RuntimeException("Cannot proceed");
        }
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        if(balance>0){
            this.balance = balance;
        }else{
            throw new RuntimeException("invalid balance");
        }

    }

    // TODO: Create a constructor to initialize
    // accountNumber and balance
    BankAccount(String accountNumber, double balance){
        setAccountNumber(accountNumber);
        setBalance(balance);
    }
    BankAccount(){
    }

    void addMoney(double amount){
        this.balance = this.balance + amount;
    }

    void subtractMoney(double amount){
        this.balance = this.balance - amount;
    }

    void showBalance(){
        System.out.println("Current Balance is "+this.balance);
    }

}
