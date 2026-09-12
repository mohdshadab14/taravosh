package com.sha.taravosh.abstract_example;

public abstract class Animal {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(String name){
        this.name = name;
    }


    public void sleep(Animal a){
        System.out.println("Animal "+a.name+ " is sleeping");
    }

    public abstract void makeSound();

}
