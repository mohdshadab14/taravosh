package com.sha.taravosh.assignments.assignment6_inheritance.assgn2;

public class Main {
    public static void main(String[] args) {
        // TODO: Create one SavingsAccount
        SavingsAccount1 savingsAccount = new SavingsAccount1("AC001",10000, 5);
        // TODO: Create one CurrentAccount
        CurrentAccount1 currentAccount = new CurrentAccount1("AC002",12000,10000);
        // TODO: Print SavingsAccount details
            System.out.println("Savings account" + "\naccount number :" + savingsAccount.accountNumber +"\nbalance : " +savingsAccount.balance + "\ninterestRate :" + savingsAccount.interestRate);

        // TODO: Print CurrentAccount details
        System.out.println("Current account" + "\naccount number :" + currentAccount.accountNumber +"\nbalance : " +currentAccount.balance + "\ninterestRate :" + currentAccount.minimumBalance); //System.out.println("Current account" + currentAccount);
    }
}