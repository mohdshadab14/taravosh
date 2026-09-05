package com.sha.taravosh.assignments.java_oops_assignment.assignment_01_bank_account_manager;

class BankAccount {

    // TODO: Create fields
    public String accountNumber;
    public String accountHolderName;
    public double balance;
    public String accountType;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

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

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
