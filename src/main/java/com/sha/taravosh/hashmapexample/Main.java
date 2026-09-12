package com.sha.taravosh.hashmapexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {

        BankAccount account1 = new BankAccount("AC001", "Alphs",10000);
        BankAccount account2 = new BankAccount("AC002", "Beta",12000);
        BankAccount account3 = new BankAccount("AC003", "Meta",15000);
        HashMap<String,BankAccount> map = new HashMap<>();
        //list has add method
        //for map it is put method
        map.put(account1.getAccountNumber(),account1);
        map.put(account2.getAccountNumber(),account2);
        map.put(account3.getAccountNumber(),account3);

        //POPULATE ACCOUNTS TO ARRAY LIST
        ArrayList<BankAccount> accuntsArray = new ArrayList<>();
        accuntsArray.add(account1);
        accuntsArray.add(account2);
        accuntsArray.add(account3);

        //CREATE A FUNCTION TEST - PASS ARRAYLIST TO FUNCTION
        test(accuntsArray);
        test_2(map);


    }

    public static void test(ArrayList<BankAccount> accountDetailsArray){
        //PRINT ACCOUNT HOLDER AND BALANCE FOR ACCOUNT AC001
        //System.out.println(accountDetailsArray);
        for(BankAccount b : accountDetailsArray){
            if(b.accountNumber == "AC001" || b.accountNumber == "AC003"){
                System.out.println(b);
            }
        }
    }
    //function to add amount to balance - assignment
    //use map to get the AC001 details
    //Hashmap is a list of key values, so for specific account details pass the Key to get the values
    //-- diff btw arrayList and Hashmap is array looks each element and hashmap find an item with key directly
    public static void test_2(HashMap<String,BankAccount> bankMap){
        //bankMap.get("AC001"); //get based on KEY and get based on INDEX
        System.out.println(bankMap.get("AC001"));
        System.out.println(bankMap.containsKey("AC004"));
    }
}
