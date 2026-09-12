package com.sha.taravosh.abstract_example;

public class UPIPayment implements PaymentMethod{
    @Override
    public void pay(int amount) {
        System.out.println("Paying through UPI");
    }
}
