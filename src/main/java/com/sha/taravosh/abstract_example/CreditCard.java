package com.sha.taravosh.abstract_example;

public class CreditCard implements PaymentMethod{



    public void pay(int amount) {
        System.out.println("Paying through Credit Card");
    }
}
