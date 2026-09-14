package com.sha.taravosh.assignments.java_oops_assignment.assignment_03_bank_management_system;


public class Customer {

    // TODO:
    // Create:
    //
    String customerId;
    String name;
    String phoneNumber;
    String city;

    // TODO:
    // Create constructor.
    Customer(String customerId, String name, String phoneNumber, String city){
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    // TODO:
    // Create displayCustomer() method.
    public void displayCustomer(){
        System.out.println("customerID : " + customerId + "\nname : " + name + "\nphoneNumber : " +  phoneNumber + "\nCity : "+city);

    }

//    @Override
//    public String toString() {
//        return super.toString();
//    }
}

