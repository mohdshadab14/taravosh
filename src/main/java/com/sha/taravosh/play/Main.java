package com.sha.taravosh.play;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Lion lion = new Lion();

        /*dog.name = "Tommy";     // inherited from Animal
        dog.age = 3;            // inherited from Animal
        dog.breed = "Labrador"; // Dog's own variable

        System.out.println(dog.name);
        System.out.println(dog.age);
        System.out.println(dog.breed);
*/
        System.out.println(dog.bark());

        System.out.println(lion.roar());

    }
}
