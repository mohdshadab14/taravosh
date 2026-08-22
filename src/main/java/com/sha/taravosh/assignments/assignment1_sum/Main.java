package com.sha.taravosh.assignments.assignment1_sum;

/*
 * ASSIGNMENT 1: Sum of Numbers
 *
 * Objective:
 * Calculate the sum of all numbers from 1 to 10.
 *
 * Concepts to use:
 * - int
 * - for loop
 * - variable initialization
 *
 * Expected output:
 * Sum = 55
 *
 * Instructions:
 * 1. Do not change the value of 'start' or 'end'.
 * 2. Use a for loop.
 * 3. Add each number to 'sum'.
 * 4. Print the final value of 'sum'.
 */

public class Main {

    public static void main(String[] args) {

        int start = 1;
        int end = 10;
        int sum = 0;

        // TODO: Write your logic here
        for(int i=start;i<=end;i++){
            sum = sum+i;
        }


        System.out.println("Sum = " + sum);
    }
}
