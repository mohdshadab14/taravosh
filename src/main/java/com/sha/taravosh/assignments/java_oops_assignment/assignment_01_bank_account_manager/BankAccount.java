package com.sha.taravosh.assignments.java_oops_assignment.assignment_01_bank_account_manager;

class BankAccount {

    // TODO: Create fields
    public String accountNumber;
    public String accountHolderName;
    public double balance;
    public String accountType;

    // TODO: Create constructor
    BankAccount(String accountNumber, String accountHolderName, double balance, String accountType){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
    }

    // TODO: Create displayAccount() method
    public void displayAccount(){
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder name : " + accountHolderName);
        System.out.println("Balance : " + balance);
        System.out.println("account type : " + accountType);

    }
}
