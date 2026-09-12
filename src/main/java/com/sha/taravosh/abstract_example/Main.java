package com.sha.taravosh.abstract_example;

public class Main {

    public static void main(String[] args) {
        /*Dog dog = new Dog("dog");

        Cat cat = new Cat("cat");

        dog.sleep(dog);
        cat.sleep(cat);

        dog.makeSound();
        cat.makeSound();*/

        PaymentMethod payment= new CreditCard();
        makePayment(payment,100);

    }

    public static void  makePayment(PaymentMethod payment,int amount){
        payment.pay(amount);
    }
}
