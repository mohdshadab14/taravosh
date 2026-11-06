package com.sha.taravosh.staticexample;

public class ExampleStaticKeyword {

    public static void main(String[] args) {
        Student s1 = new Student(35,"Shadab");
        s1.increment();

        System.out.println(Student.counter);

        Student s2 = new Student();

        s2.increment();
        System.out.println(Student.counter);

        System.out.println(MathUtil.square(5));

    }


}
