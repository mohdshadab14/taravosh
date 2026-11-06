package com.sha.taravosh.staticexample;

public class Student {
    int age;
    String name;

    static int counter = 0;

    public Student(){}

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    void increment() {
        counter++;
    }

}

