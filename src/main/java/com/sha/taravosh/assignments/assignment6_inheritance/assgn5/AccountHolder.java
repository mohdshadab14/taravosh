package com.sha.taravosh.assignments.assignment6_inheritance.assgn5;

public class AccountHolder {

    private String name;
    private int age;
    private String phoneNumber;


    // TODO: Create setName()
    // Name must not be empty
    public void setName(String name){
        if(name != null){
            this.name= name;
        }else{
            System.out.println("Invalid name");
        }
    }

    // TODO: Create getName()

    public String getName() {
        return name;
    }


    // TODO: Create setAge()
    // Age must be greater than 0

    public void setAge(int age) {
        if(age > 0){
            this.age = age;
        }else{
            System.out.println("Invalid age");
        }
    }

    // TODO: Create getAge()
    public int getAge() {
        return age;
    }

    // TODO: Create setPhoneNumber()
    // Phone number must contain exactly 10 digits

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length()  ==10){
            this.phoneNumber = phoneNumber;
        }else{
            System.out.println("Invalid phonenumber");
        }
    }

    // TODO: Create getPhoneNumber()

    public String getPhoneNumber() {
        return phoneNumber;
    }
}


