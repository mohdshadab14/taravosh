package com.sha.taravosh.assignments.assignment4_student_marks;


public class Main {

    public static void main(String[] args) {

        // TODO: Create a Student object using 'new'
            Student rahul = new Student("Rahul");
            rahul.marksEnglish = 80;
            rahul.marksFrench = 60;
            rahul.marksHindi = 80;
            rahul.marksMath =100;
            rahul.marksSci = 95;
        // TODO: Print student name
        System.out.println(rahul.calculateTotalMarks());
        // TODO: Call calculateTotalMarks()
        //       and print the result
    }
}
