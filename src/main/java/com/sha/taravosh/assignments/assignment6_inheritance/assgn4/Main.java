package com.sha.taravosh.assignments.assignment6_inheritance.assgn4;

public class Main {

    public static void main(String[] args) {

        AccountHolder holder = new AccountHolder();

        // TODO: Set valid name
        holder.setName("Musk");
        // TODO: Set valid age
        holder.setAge(30);
        // TODO: Set valid phone number
        holder.setPhoneNumber("8110089884");
        // TODO: Print all values using getters
        System.out.println("Name : "+ holder.getName());
        System.out.println("age : " + holder.getAge());
        System.out.println("PhoneNumber : "+holder.getPhoneNumber());

        // Test validation

        // TODO: Try setting an invalid age
        holder.setAge(-10);

        // TODO: Try setting an invalid phone number
    holder.setPhoneNumber("123456789011");

        // TODO: Print values again and verify
        // that invalid values were not stored
        System.out.println("New Age : "+holder.getAge());
        System.out.println("new PhoneNumber" + holder.getPhoneNumber());
    }
}
