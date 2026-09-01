package com.sha.taravosh.assignments.assignment6_inheritance.assgn4;

public class AccountHolder {

    // TODO:
    // Change these variables to private
    public String name;
    public  int age;
    public String phoneNumber;

    // TODO: Create setName()
    //// Validation:// Name should not be empty
    public void setName(String Name){
        if(name != null){
            this.name = Name;
        }else{
            System.out.println("name should not be empty");
        }
    }

    // TODO: Create getName()
public String getName(){
        return name;
}
    // TODO: Create setAge()
    //// Validation:// Age must be greater than 0
    public void setAge(int Age){
        if(this.age > 0) {
            this.age = Age;
        }else{
            System.out.println("age must be greater than 0");
        }
    }

    // TODO: Create getAge()
    public int getAge() {
        return age;
    }

    // TODO: Create setPhoneNumber()
    //// Validation:// Phone number must contain exactly 10 digits
 public void setPhoneNumber(String phoneNumber){
     if(phoneNumber.length() == 10){
         this.phoneNumber = phoneNumber;
     }else{
         System.out.println("PhoneNumber musr have atleast 10 digits");
     }
 }
// TODO: Create getPhoneNumber()
    public String getPhoneNumber(){
     return phoneNumber;
    }
}

