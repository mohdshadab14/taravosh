package com.sha.taravosh.assignments.assignment6_inheritance.assgn3;

public class Main {
    public static void main(String[] args) {
        // TODO: Create a SavingsAccount object
        SavingsAccount savingsAccount = new SavingsAccount("SV001",10000,5);
        // TODO: Display savings account details
        System.out.println("Savings Account details ----------");
        savingsAccount.displaySavingsDetails();
        // TODO: Create a CurrentAccount object
        CurrentAccount currentAccount = new CurrentAccount("AC001",10000, 5000);
        // TODO: Display current account details
        System.out.println("Current Account details ----------");
        currentAccount.displayCurrentAccountDetails();

    }
}

