package com.sha.taravosh.assignments.java_oops_assignment.assignment_01_bank_account_manager;


import java.util.ArrayList;

public class BankAccountManager {

    public static void main(String[] args) {

        // Create an ArrayList to store BankAccount objects
        ArrayList<BankAccount> accounts = new ArrayList<>();

        // TODO 1:
        // Create at least 5 BankAccount objects using the constructor.
        BankAccount account1 = new BankAccount("A001","A-One",10000,"Savings Account");
        BankAccount account2 = new BankAccount("A002","A-Two",15000,"Current Account");
        BankAccount account3 = new BankAccount("A003","A-Three",12000,"Savings Account");
        BankAccount account4 = new BankAccount("A004","A-Four",14000,"Current Account");
        BankAccount account5 = new BankAccount("A005","A-Five",20000,"Savings Account");

        // TODO 2:
        // Add all the accounts to the ArrayList.
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);

        // TODO 3:
        // Use an enhanced for loop to print all accounts.
        for(BankAccount a: accounts){
           a.displayAccount();
            System.out.println("--------");
        }

        // TODO 4:
        // Calculate and print the total balance of all accounts.
        // Expected:
        // Total Bank Balance: XXXXX
        double total_balance = 0;
        for(BankAccount a:accounts){
            total_balance = total_balance + a.balance;
        }
        System.out.println("total balance = " + total_balance);

        // TODO 5:
        // Find the account with the highest balance.
        //
        // Print the account holder and balance.

        // TODO 6 - BONUS:
        // Count how many Savings and Current accounts exist.

    }
}


/*
 * TODO:
 *
 * Create the BankAccount class.
 *
 * Fields:
 * - accountNumber
 * - accountHolderName
 * - balance
 * - accountType
 *
 * Create a constructor to initialize all fields.
 *
 * You may also create a method:
 *
 * public void displayAccount()
 *
 * to display account information.
 */


