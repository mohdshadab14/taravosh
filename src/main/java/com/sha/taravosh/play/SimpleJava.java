package com.sha.taravosh.play;

import java.util.ArrayList;
import java.util.List;

public class SimpleJava {

    public static void main(String[] args) {

        List<User> allusers = giveAllUsers();


    }


    public static List<User> giveAllUsers(){
        List<User> users = new ArrayList<>();

        User shadab = new User(1,"mohdshadab","Mohamad","Shadab","mohd@gmail.com",35);
        User s = new User(1,"hadab","Mohd","Shadab","mohd@gmail.com",35);
        User h = new User(1,"mohd","Mohamad","Sha","mohd@gmail.com",35);
        User a = new User(1,"mo","Mo","Sha","mohd@gmail.com",35);

        users.add(shadab);
        users.add(s);
        users.add(h);
        users.add(a);

        return users;
    }
}