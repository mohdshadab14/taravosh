package com.sha.taravosh.overridingexample;

public class Main {

    public static void main(String[] args) {

        SavingsAccount savingsAccount =
                new SavingsAccount("Shadab", 100000);

        CurrentAccount currentAccount =
                new CurrentAccount("Rahul", 100000);

        System.out.println("----- Savings Account -----");

        savingsAccount.displayAccountDetails();
        savingsAccount.calculateInterest();

        currentAccount.calculateInterest();
        System.out.println();

        System.out.println("----- Current Account -----");

        currentAccount.displayAccountDetails();
        currentAccount.calculateInterest();
    }
}

