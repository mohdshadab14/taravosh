package com.sha.taravosh.hashmapexample;

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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // TODO 3:
    // Create a method to display the common account information.
    //
    public void displayAccount(){
        System.out.println("Account Number : " + accountNumber + "\nAccountHolder : "+accountHolder + "\nBlance : " + balance);
    }
    //use toString()

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                '}';
    }
}


