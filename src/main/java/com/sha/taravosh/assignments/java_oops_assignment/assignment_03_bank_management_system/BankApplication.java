package com.sha.taravosh.assignments.java_oops_assignment.assignment_03_bank_management_system;

import java.util.ArrayList;

public class BankApplication {

    public static void main(String[] args) {

        // ==========================================
        // TODO 1: CREATE CUSTOMERS
        // ==========================================

        // Create at least 4 Customer objects.
        Customer customer1 = new Customer("Cust001", "Aura", "9191919191","Delhi");
        Customer customer2 = new Customer("Cust002", "Suma", "91900091","Mumbai");
        Customer customer3 = new Customer("Cust003", "Roshna", "80900091","Hyd");
        Customer customer4 = new Customer("Cust004", "Kishan", "809000101","Chennai");

        // ==========================================
        // TODO 2: CREATE ACCOUNTS
        // ==========================================

        // Create at least 6 accounts.
        //
        // At least:
        // 3 SavingsAccount
        // 3 CurrentAccount
        //
        // Each account should belong to a Customer.
        SavingsAccount savingsAccount_1 = new SavingsAccount(5,5000,"SAV001",10000, customer1);
        SavingsAccount savingsAccount_2 = new SavingsAccount(5,5000,"SAV002",18000, customer2);
        SavingsAccount savingsAccount_3 = new SavingsAccount(6,6000,"SAV003",20000, customer3);

        CurrentAccount currentAccount_1 = new CurrentAccount("AXA Co",50000,"CUR001",100000, customer1);
        CurrentAccount currentAccount_2 = new CurrentAccount("Micron",50000,"CUR002",180000, customer2);
        CurrentAccount currentAccount_3= new CurrentAccount("Mini",60000,"CUR003",200000, customer3);

        // ==========================================
        // TODO 3: CREATE ARRAYLIST
        // ==========================================

        // Create:
        //
        // ArrayList<com.sha.taravosh.oops_assignment.bank_account_management.BankAccount> accounts
        //
        // Store all accounts in it.
        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(savingsAccount_1);
        accounts.add(savingsAccount_2);
        accounts.add(savingsAccount_3);
        accounts.add(currentAccount_1);
        accounts.add(currentAccount_2);
        accounts.add(currentAccount_3);

        // ==========================================
        // TODO 4: DISPLAY BANK REPORT
        // ==========================================

        // Use an enhanced for loop.
        //
        // Display:
        // Account Number
        // Customer Name
        // City
        // Balance
        // Account Type
        for (BankAccount a: accounts){
            System.out.println(a.getAccountNumber());
            System.out.println(a.getCustomer().name);
            System.out.println(a.getCustomer().city);
            System.out.println(a.getBalance());
            if(a instanceof SavingsAccount){
                System.out.println("Saving Account");
            }else if(a instanceof CurrentAccount){
                System.out.println("Current Account");
            }
        }

        // ==========================================
        // TODO 5: TOTAL BANK BALANCE
        // ==========================================

        // Calculate the total balance
        // of all accounts.
        double totalBalance = 0;
        for(BankAccount a: accounts){
            totalBalance = totalBalance + a.getBalance();
        }
        System.out.println("Total Balance == " + totalBalance );

        // ==========================================
        // TODO 6: HIGHEST BALANCE
        // ==========================================

        // Find the account with
        // the highest balance.
        double highestBalance = 0;
        for(BankAccount a : accounts){
            if(a.getBalance() > highestBalance){
                highestBalance = a.getBalance();
            }
        }
        System.out.println("Highest balance" + highestBalance);

        // ==========================================
        // TODO 7: ACCOUNT TYPE COUNT
        // ==========================================

        // Count:
        //
        // Savings Accounts
        // Current Accounts
        int countOfSavingsAcc = 0;
        int countOfCurrentAcc = 0;
        for (BankAccount a: accounts){
            if(a instanceof SavingsAccount){
                countOfSavingsAcc ++;
            }else if(a instanceof CurrentAccount){
               countOfCurrentAcc++;
            }
        }
        System.out.println("Count of Saving Account -- " + countOfSavingsAcc );
        System.out.println("Count of Current Account -- " + countOfCurrentAcc );

        // ==========================================
        // TODO 8: SEARCH CUSTOMER
        // ==========================================

        // Search and display all accounts
        // belonging to a particular customer.
        //
        // Example:
        //
        // Search: Shadab
        //
        // ACC101 -> Savings -> 50000
        // ACC105 -> Current -> 75000

    }
}
