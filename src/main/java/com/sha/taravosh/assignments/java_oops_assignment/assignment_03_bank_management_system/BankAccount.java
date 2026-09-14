package com.sha.taravosh.assignments.java_oops_assignment.assignment_03_bank_management_system;


public class BankAccount {

    // TODO:
    // Create:
    //
    // accountNumber
    // balance
    // Customer customer
    String accountNumber;
    double balance;
    Customer customer;

    // TODO:
    // Create constructor.
    BankAccount(String accountNumber, double balance, Customer customer){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // TODO:
    // Create displayAccount() method.
    public void displayAccount(){
        System.out.println("Account number :" + accountNumber);
        System.out.println("balance : " + balance);
        System.out.println("customer" + customer);
    }
}
