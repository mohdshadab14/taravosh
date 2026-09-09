package com.sha.taravosh.assignments.java_oops_assignment.assignment_02_bank_account_inheritance;


import java.util.ArrayList;

public class BankApplication {

    public static void main(String[] args) {

        // TODO 1:
        // Create 3 SavingsAccount objects.
        SavingsAccount savingsAccount1 = new SavingsAccount("SAV001", "Savi_1", 1000, 6,5000);
        SavingsAccount savingsAccount2 = new SavingsAccount("SAV002", "Savi_2", 10000, 6,5000);
        SavingsAccount savingsAccount3 = new SavingsAccount("SAV003", "Savi_3", 8000, 6,5000);

        // TODO 2:
        // Create 2 CurrentAccount objects.
        CurrentAccount currentAccount_1 = new CurrentAccount("CA001", "Current_1", 5000, "Alpha Tech",10000);
        CurrentAccount currentAccount_2 = new CurrentAccount("CA002", "Current_2", 15000, "Beta Tech",10000);

        // TODO 3:
        // Create an ArrayList that can store
        // both SavingsAccount and CurrentAccount objects.
        //
        // Hint:
        // ArrayList<BankAccount>
        ArrayList<BankAccount> account = new ArrayList<>();
        // TODO 4:
        // Add all accounts to the ArrayList.
        account.add(savingsAccount1);
        account.add(savingsAccount2);
        account.add(savingsAccount3);
        account.add(currentAccount_1);
        account.add(currentAccount_2);

        // TODO 5:
        // Use an enhanced for loop to display
        // all accounts.
        for (BankAccount a: account){
            a.displayAccount();
            System.out.println();
        }
        // TODO 6:
        // Calculate the total balance
        // of all accounts.
        double totalBalance = 0;
        for(BankAccount a: account){
            totalBalance = totalBalance+a.balance;
        }
        System.out.println("Total Balance : " + totalBalance);

        // TODO 7:
        // Find the account with the highest balance.
        double highestBalance = 0;
        for(BankAccount a: account){
            if(a.balance > highestBalance){
                highestBalance = a.balance;
            }
        }
        System.out.println("Highest Balance : " + highestBalance);

        // TODO 8 - BONUS:
        // Use instanceof to count:
        //
        // SavingsAccount
        // CurrentAccount
        int savingsAccount = 0;
        int currentAccount = 0;
        for(BankAccount a: account) {
            if(a instanceof SavingsAccount){
                savingsAccount++;
            } else if (a instanceof CurrentAccount) {
                currentAccount++;
            }
        }
        System.out.println("number of saving accounts : " + savingsAccount);
        System.out.println("number of current accounts : " + currentAccount);
    }
}
