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
        if(Name != null){
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
    public void setAge(int age){

        //At this point when age is being compared with 0, value present in this.age is 0 hence you need to have comparison on value which you are going to set
        //if(this.age > 0) {
        if(age > 0) {
            this.age = age;
        }
        else{
            throw new RuntimeException("age must be >0");
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
     }
//     else{
//         throw new RuntimeException("invalid phonenumber");
//     }
 }
// TODO: Create getPhoneNumber()
    public String getPhoneNumber(){
     return phoneNumber;
    }
}

