package com.sha.taravosh.collection;


import java.util.ArrayList;

public class StudentManager {

    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();

        // TODO 1: Add 5 student names to the list
        students.add("Alpha");
        students.add("newton");
        students.add("Musk");
        students.add("Rahul");
        students.add("Oman");

        // TODO 2: Print all students using an enhanced for loop
        for(String s:students){
            System.out.println(s);
        }

        // TODO 3: Print the total number of students
        System.out.println("total student  "+students.size());

        // TODO 4: Remove one student from the list
        students.remove("Musk");

        // TODO 5: Print the list after removing the student
        System.out.println("after removing a value " + students);

        // TODO 6: Print the first student in the list
        System.out.println("first student : "+ students.getFirst());

        // TODO 7: Print all students using a normal for loop
        for(int i=0; i<students.size(); i++){
            System.out.println("students " + students.get(i));
        }

    }
}