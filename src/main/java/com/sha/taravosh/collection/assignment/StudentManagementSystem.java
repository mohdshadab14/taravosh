package com.sha.taravosh.collection.assignment;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentManagementSystem {

    private ArrayList<Student> students;
    private HashMap<Integer, Student> studentMap;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        studentMap = new HashMap<>();
    }

    public void addStudent(Student student) {
        // TODO:
        // 1. Check whether the student ID already exists.
        // 2. If it exists, display a suitable message.
        // 3. Otherwise, add the student to both collections.
    }

    public void displayAllStudents() {
        // TODO:
        // 1. Check whether the ArrayList is empty.
        // 2. If empty, display a suitable message.
        // 3. Otherwise, iterate over the ArrayList.
        // 4. Call displayDetails() for each student.
    }

    public Student findStudentById(int studentId) {
        // TODO:
        // 1. Check whether the HashMap contains the student ID.
        // 2. Return the Student object if found.
        // 3. Return null if not found.

        return null;
    }

    public boolean removeStudent(int studentId) {
        // TODO:
        // 1. Check whether the student exists in the HashMap.
        // 2. If not found, return false.
        // 3. Get the Student object from the HashMap.
        // 4. Remove the student from the HashMap.
        // 5. Remove the student from the ArrayList.
        // 6. Return true.

        return false;
    }

    public int getStudentCount() {
        // TODO: Return the number of students.
        return 0;
    }

    public boolean studentExists(int studentId) {
        // TODO: Use HashMap.containsKey()
        return false;
    }

    public void displayStudentsByCourse(String courseName) {
        // TODO:
        // 1. Iterate over the ArrayList.
        // 2. Compare each student's course name with courseName.
        // 3. Display matching students.
        // 4. Display a message if no matching student is found.
    }

    public void clearStudents() {
        // TODO:
        // Clear both collections.
    }
}