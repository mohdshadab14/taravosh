package com.sha.taravosh.play;

import java.util.ArrayList;
import java.util.List;

public class SimpleJava {

    public static void main(String[] args) {

        List<User> allusers = giveAllUsers();

        System.out.println(allusers);

        //create a for loop. Set all user ids in sequence 1,2,3,4,5

        for (int i=0 ; i<allusers.size();i++){
            User user = allusers.get(i);
            System.out.println(user);
            user.id = i+1;
        }

        System.out.println("\n");
        for(User u:allusers){
            System.out.println(u);
        }


        // to update Ids in reverse 5,4,3,2,1

    }


    public static List<User> giveAllUsers(){

        List<User> users = new ArrayList<>();

        User shadab = new User(1,"mohdshadab","Mohamad","Shadab","mohd@gmail.com",35);
        User s = new User(2,"hadab","Mohd","Shadab","mohd@gmail.com",35);
        User h = new User(50,"mohd","Mohamad","Sha","mohd@gmail.com",35);
        User a = new User(4,"mo","Mo","Sha","mohd@gmail.com",35);

        User nowhera = new User(10,"nowhera");

       users.add(shadab);
        users.add(s);
        users.add(h);
        users.add(a);
        users.add(nowhera);

        return users;
    }


    float sum(float a,int b){
        return a+b;
    }
}