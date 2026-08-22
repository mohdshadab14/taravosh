package com.sha.taravosh.assignments.assignment2_multiplication_table;

/*
 * ASSIGNMENT 2: Multiplication Table
 *
 * Objective:
 * Print the multiplication table of a given number from 1 to 10.
 *
 * Concepts to use:
 * - int
 * - while loop
 * - arithmetic operators
 *
 * Expected output for number = 7:
 *
 * 7 x 1 = 7
 * 7 x 2 = 14
 * 7 x 3 = 21
 * ...
 * 7 x 10 = 70
 *
 * Instructions:
 * 1. Do not change the value of 'number'.
 * 2. Use a while loop.
 * 3. Start the counter from 1.
 * 4. Continue until the counter reaches 10.
 * 5. Print the multiplication result in the format shown above.
 */

public class Main {

    public static void main(String[] args) {

        int number = 7;
        int counter = 1;

        // TODO: Write your while loop here
        while (counter<=10){
            int table = number * counter;
            System.out.println(number+ "*"+ counter +"="+table);
            counter++;
        }

    }
}
