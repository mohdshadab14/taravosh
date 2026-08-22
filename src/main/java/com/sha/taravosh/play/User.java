package com.sha.taravosh.play;

public class User {

    public long id;
    public String userId;
    public String firstName;
    public String lastName;
    public String email;
    public int age;

    User(){}

    public User(long id, String userId, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
}

