package com.sha.taravosh.assignments.assignment4_student_marks;

/*
 * ASSIGNMENT 4: Student Marks
 *
 * Objective:
 * Create a Student object using a constructor and calculate
 * the total marks obtained in 5 subjects.
 *
 * Concepts to use:
 * - int
 * - class
 * - object creation using 'new'
 * - constructor
 * - for loop
 *
 * Expected output:
 *
 * Student: Rahul
 * Total Marks = 400
 *
 * Instructions:
 * 1. Complete the Student class constructor.
 * 2. Create a Student object using 'new'.
 * 3. The student has 5 subjects.
 * 4. Use a for loop to calculate the total marks.
 *
 * Important:
 * Do not use arrays or collections.
 */

class Student {

    String name;
    int marksPerSubject;
///nowheera - doubt why should i need to declare type in the constructor
    // TODO: Create a constructor that initializes
    //       name and marksPerSubject
    public Student(String name, int marksPerSubject){
        this.name = name;
        this.marksPerSubject = marksPerSubject;

    }

    int calculateTotalMarks() {

        int total = 0;
         for( int Student =0; Student<=5; Student++){
             total = marksPerSubject;
         }
        // TODO: Use a for loop to add marksPerSubject
        //       5 times
        return total;
    }
}
