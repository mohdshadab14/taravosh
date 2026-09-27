package com.sha.taravosh.service;

import com.sha.taravosh.model.Customer;
import com.sha.taravosh.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {

    //injustcting bean of CustomerService
    @Autowired
    private CustomerService customerService;

    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        Student student = new Student("Mohammad","Shadab");
        students.add(student);
        System.out.println(students);
        return students;
    }

    public List<Customer> getCustomerFromStudent(){

        return customerService.getCustomers();
    }

}
