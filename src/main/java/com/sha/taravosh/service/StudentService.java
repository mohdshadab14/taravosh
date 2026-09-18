package com.sha.taravosh.service;

import com.sha.taravosh.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        Student student = new Student("Mohammad","Shadab");
        students.add(student);
        System.out.println(students);
        return students;
    }
}
