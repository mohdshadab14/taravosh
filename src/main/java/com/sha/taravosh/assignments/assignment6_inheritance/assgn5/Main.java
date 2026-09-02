package com.sha.taravosh.assignments.assignment6_inheritance.assgn5;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // =========================
        // ACCOUNT HOLDER
        // =========================

        AccountHolder holder = new AccountHolder();

        // TODO: Set name
        holder.setName("John");
        // TODO: Set age
        holder.setAge(25);
        // TODO: Set phone number
        holder.setPhoneNumber("8110089884");

        // =========================
        // SAVINGS ACCOUNT
        // =========================

        // TODO: Create SavingsAccount
        SavingsAccount savingAccount = new SavingsAccount("A001",10000,5);
        // =========================
        // DISPLAY PROFILE
        // =========================

        System.out.println("----- Account Holder -----");

        // TODO: Print name using getter
        System.out.println("name : "+ holder.getName());
        // TODO: Print age using getter
        System.out.println("age : "+ holder.getAge());
        // TODO: Print phone using getter
        System.out.println("phone : " + holder.getPhoneNumber());

        System.out.println("----- Savings Account -----");

        // TODO: Display savings account details
        savingAccount.displaySavingsDetails();

        // =========================
        // VALIDATION TEST
        // =========================

        // TODO: Try an invalid age
        holder.setAge(-10);
        // TODO: Try an invalid phone number
        holder.setPhoneNumber("1234500000");
        // TODO: Print the values again
        // and verify invalid values were rejected
        System.out.println("new age : " + holder.getAge());  // the invalid age is validated in the previous step -> method setAge. unless its over written by another this.name
        System.out.println("new phoneNumber : " + holder.getPhoneNumber()); // same for the phone number

        //---------CREATE AN ARRAYLIST

        ArrayList<SavingsAccount> accoutHolders = new ArrayList<>();
        SavingsAccount savingsAccount_1 = new SavingsAccount("AC005",10000, 6);
        SavingsAccount savingsAccount_2 = new SavingsAccount("AC006",15000, 6);
        SavingsAccount savingsAccount_3 = new SavingsAccount("AC007",18000, 6);
        accoutHolders.add(savingsAccount_1);
        accoutHolders.add(savingsAccount_2);
        accoutHolders.add(savingsAccount_3);
        //For each loop where each element is iterated in the list
        //each part : "SavingsAccount a"  each element a (a is of a type Savings Account )of list// list "accoutHolders"

        for(SavingsAccount a:accoutHolders){
            a.displaySavingsDetails();
            System.out.println();
        }



    }
}
