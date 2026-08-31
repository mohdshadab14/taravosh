package com.sha.taravosh.assignments.assignment5_bank_account;

public class Main {

    public static void main(String[] args) {

        // TODO: Create a BankAccount object using 'new'
        //       Initial balance = 5000
        //       Monthly deposit = 100
    BankAccount bankAccount = new BankAccount(5000,100);

        // TODO: Print the initial balance
        System.out.println("Initial balance " + bankAccount.initialBalance);

        // TODO: Print the monthly deposit
        System.out.println("monthly deposit" + bankAccount.monthlyDeposit);

        // TODO: Calculate and print the final balance
        System.out.println("final balance" + bankAccount.calculateFinalBalance());
    }
}
