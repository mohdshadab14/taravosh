package com.sha.taravosh.controller;

import com.sha.taravosh.model.Customer;
import com.sha.taravosh.model.Student;
import com.sha.taravosh.service.CustomerService;
import com.sha.taravosh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    //injuction classes
    @Autowired
    private CustomerService customerService;

    @Autowired
    private StudentService studentService;
    //CustomerService - service - java object - bean
    //Singleton Class: if a class having only one object throughout the application lifecyle.
    //this is PRIVATE - BCZ -


    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        System.out.println("Inside get students");
        //StudentService studentService = new StudentService();

        List<Student> students = studentService.getStudents();
        System.out.println(students);
        return students;
    }

    @GetMapping("/getCustomers")
    public List<Customer> getCustomers() {
        System.out.println("Inside get customers");
        return customerService.getCustomers();  //all logic in the service layer --
    }

    @GetMapping("/getCustomerFromStudent")
    public List<Customer> getCustomerFromStudent() {
        System.out.println("Inside get CustomerFromStudent");
        //StudentService studentService = new StudentService();

        List<Customer> customers = studentService.getCustomerFromStudent();
        System.out.println(customers);
        return customers;
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@RequestBody Customer customer) {
        System.out.println("Inside create customer");
        customerService.createCustomer(customer);
        return "Customer created";
    }
    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable long id) {
        System.out.println("Inside delete customer");
        int rows = customerService.deleteCustomer(id);
        return rows > 0 ? "Customer deleted" : "Customer not found";
    }

    @GetMapping("getCustomers/{id}")
    public List<Customer> getCustomers(@PathVariable long id){
        System.out.println("Try to get one customer with id");
        List<Customer> customers = customerService.getCustomers(id);
        return customers;
    }
}
