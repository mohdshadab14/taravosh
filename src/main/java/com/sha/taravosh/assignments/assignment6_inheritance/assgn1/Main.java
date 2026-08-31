package com.sha.taravosh.assignments.assignment6_inheritance.assgn1;

public class Main {
    public static void main(String[] args) {

        // TODO: Create a SavingsAccount object
        // Example:
        // SavingsAccount account =  new SavingsAccount("ACC101", 50000, 6.5);
        try{
            SavingsAccount my_account = new SavingsAccount("ACC1001000000000",-10);
            // TODO: Print account number
            System.out.println("Account Number :  "+my_account.getAccountNumber());

            my_account.showBalance();
            System.out.println("Account Interest Rate :" + my_account.getInterestRate());

            // TODO: Print balance
            // TODO: Print interest rate

            my_account.addMoney(100);
            my_account.showBalance();
            my_account.subtractMoney(1000);
            my_account.showBalance();
            my_account.setLocation("Limerick");
            System.out.println("location : " + my_account.getLocation());
        } catch (RuntimeException e) {
            System.out.println("validation error for SavingAccount" + e.getMessage());
        }
        System.out.println("continue creation of other object");

//        SavingsAccount account_1 = new SavingsAccount("ACC1001000000020",1000);
//        SavingsAccount account_2 = new SavingsAccount("ACC1001000000010",2000);
        System.out.println("intrest " + SavingsAccount.getInterestRate());


    }

}
