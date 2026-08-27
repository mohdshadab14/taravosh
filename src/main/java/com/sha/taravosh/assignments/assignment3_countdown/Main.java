package com.sha.taravosh.assignments.assignment3_countdown;

/*
 * ASSIGNMENT 3: Countdown
 *
 * Objective:
 * Print a countdown from 5 to 1 and then print "Go!".
 *
 * Concepts to use:
 * - int
 * - while loop
 * - decrement operator
 *
 * Expected output:
 *
 * 5
 * 4
 * 3
 * 2
 * 1
 * Go!
 *
 * Instructions:
 * 1. Do not change the value of 'count'.
 * 2. Use a while loop.
 * 3. Print the current value of count.
 * 4. Decrease count after every iteration.
 * 5. Print "Go!" after the loop finishes.
 */

public class Main {

    public static void main(String[] args) {
        int count = 5;

//        // TODO: Write your countdown logic here
       while (count>0 ) {
        // TODO: Print "Go!" here
        System.out.println(count);
           count--;
       }
        System.out.println("GO!");
    }
}
