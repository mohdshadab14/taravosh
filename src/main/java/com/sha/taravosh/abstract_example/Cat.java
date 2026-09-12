package com.sha.taravosh.abstract_example;

public class Cat extends Animal{

    public Cat(String name){
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Cat is making sound");
    }

}
