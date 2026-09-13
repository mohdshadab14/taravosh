package com.sha.taravosh.collection.assignment;

public class Main {

    public static void main(String[] args) {

        StudentManagementSystem system =
                new StudentManagementSystem();

        // Add students
        system.addStudent(
                new Student(101, "Amit", "Java")
        );

        system.addStudent(
                new Student(102, "Sara", "Python")
        );

        system.addStudent(
                new Student(103, "Rahul", "Java")
        );

        system.addStudent(
                new Student(104, "Neha", "Spring Boot")
        );

        // Try adding a duplicate student ID
        system.addStudent(
                new Student(101, "Another Student", "Java")
        );

        System.out.println("\nAll Students:");
        system.displayAllStudents();

        System.out.println("\nSearch Student:");
        Student student = system.findStudentById(102);

        if (student != null) {
            student.displayDetails();
        } else {
            System.out.println("Student not found");
        }

        System.out.println("\nStudents enrolled in Java:");
        system.displayStudentsByCourse("Java");

        System.out.println("\nTotal Students:");
        System.out.println(system.getStudentCount());

        System.out.println("\nChecking Student 103:");
        System.out.println(system.studentExists(103));

        System.out.println("\nRemoving Student 101:");
        boolean removed = system.removeStudent(101);
        System.out.println("Removed: " + removed);

        System.out.println("\nStudents after removal:");
        system.displayAllStudents();

        System.out.println("\nChecking Student 101:");
        System.out.println(system.studentExists(101));
    }
}