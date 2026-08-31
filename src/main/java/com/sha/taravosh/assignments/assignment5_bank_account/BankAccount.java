package com.sha.taravosh.assignments.assignment5_bank_account;

/*
 * ASSIGNMENT 5: Bank Account
 *
 * Objective:
 * Create a BankAccount object and calculate the balance
 * after making the same deposit every month for 12 months.
 *
 * Concepts to use:
 * - int
 * - class
 * - object creation using 'new'
 * - constructor
 * - for loop
 * - arithmetic operators
 *
 * Given:
 * Initial Balance = 5000
 * Monthly Deposit = 100
 * Number of Months = 12
 *
 * Expected output:
 *
 * Initial Balance = 5000
 * Monthly Deposit = 100
 * Final Balance = 6200
 *
 * Instructions:
 * 1. Complete the BankAccount constructor.
 * 2. Store initialBalance and monthlyDeposit in the object.
 * 3. Create a BankAccount object using 'new'.
 * 4. Use a for loop to make the monthly deposit 12 times.
 * 5. Calculate and print the final balance.
 *
 * Important:
 * Do not use arrays, collections, or any advanced Java features.
 */

class BankAccount {

    int initialBalance;
    int monthlyDeposit;

    // TODO: Create a constructor that initializes
    //       initialBalance and monthlyDeposit
    public BankAccount(int initialBalance, int monthlyDeposit){
        this.initialBalance = initialBalance;
        this.monthlyDeposit = monthlyDeposit;
    }

    int calculateFinalBalance() {
        int balance = initialBalance;
        // TODO: Use a for loop.
        //       Add monthlyDeposit to balance
        //       12 times.
        for(int i =0; i<=12;i++) {
            balance = balance + monthlyDeposit;
            //System.out.println("total balance" + balance);
        }
        return balance;
    }
}
