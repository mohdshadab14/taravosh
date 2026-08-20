package com.sha.taravosh.play;

public class SimpleJava {

    public static void main(String[] args) {

        User user1 = new User("Shadab");

        User user2 = new User("xyz");
        User user3 = new User("Testing");


        //user2.name = "some name";



        System.out.println("User 1 Name is "+user1.name);
        System.out.println("User 2 Name is "+user2.name);
        System.out.println("User 3 name is "+user3.name);
        int[] b = new int[100];
        b[0] = 1;
        b[5] = 100;

        for(int i=0;i<100;i++){
            //System.out.println("Value of array b index"+ i+ "is "+ b[i]);
        }
    }


}
