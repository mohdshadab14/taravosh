package com.sha.taravosh.assignments.java_oops_assignment.assignment_02_bank_account_inheritance;

public class SavingsAccount extends BankAccount {

    // TODO 1:
    // Create:
    int interestRate;
    double minimumBalance;

    // TODO 2:
    // Create a constructor.
    // Use super() to initialize the fields
    // inherited from BankAccount.
    SavingsAccount(String accountNumber, String accountHolder, double balance, int interestRate, double minimumBalance){
            super(accountNumber, accountHolder, balance);
            this.interestRate = interestRate;
            this.minimumBalance = minimumBalance;
    }
    // TODO 3:
    // Create a method to display SavingsAccount information.
    public void displaySavingsAccountDetails(){
        displayAccount();
        System.out.println("Interest Rate : " + interestRate + "\nMinimumBalance" + minimumBalance);

    }
}

