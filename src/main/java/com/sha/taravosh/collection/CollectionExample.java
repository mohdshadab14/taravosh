package com.sha.taravosh.collection;

import java.util.ArrayList;

public class CollectionExample {



    public static void main(String[] args) {

        //Store names of students
        String student = "Shadab";
        String student2 = "nowheera";
        String student3 ="rahul";

        String[] students = new String[5];

        students[0] = "shadab";
        students[1] = "rahul";

        ArrayList<String> listOfStudents = new ArrayList<>();

        System.out.println(listOfStudents);

        listOfStudents.add("Shadab");
        listOfStudents.add("Rahul");
        listOfStudents.add("xyz");
        listOfStudents.add("abc");

        //System.out.println(listOfStudents);
        //listOfStudents.remove("Shadab");
        //System.out.println(listOfStudents);

        for(String s : listOfStudents){
            System.out.println(s);
        }

        for(int i=0; i< listOfStudents.size();i++){
            System.out.println(listOfStudents.get(i));
        }

    }




}
