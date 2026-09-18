package com.sha.taravosh.controller;

import com.sha.taravosh.model.Student;
import com.sha.taravosh.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        System.out.println("Inside get students");
        StudentService studentService = new StudentService();

        List<Student> students = studentService.getStudents();
        System.out.println(students);
        return students;
    }

}
