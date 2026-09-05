package com.sha.taravosh.play;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> person = new ArrayList<>();
        person.add(1000);
        person.add(500);
        person.add(5000);
        person.add(3000);
        person.add(10000);
        person.add(6000);
        person.add(60);
        person.add(800);
        person.add(9000);
        person.add(9000);

        for(Integer p:person){
            System.out.println("single value" + p);
        }
        //empty var
        Integer maxValue = person.get(0);
        for(Integer p: person){   //loop every element
            if(p > maxValue){ //compare with variable
                System.out.println("replacing max with new max "+ maxValue +" : "+p);
                maxValue = p;
            }
        }
        System.out.println("Max value"+maxValue);

    }
}
