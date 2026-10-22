package com.sha.taravosh.controller;

import com.sha.taravosh.model.Customer;
import com.sha.taravosh.model.Student;
import com.sha.taravosh.service.CustomerService;
import com.sha.taravosh.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class HelloController {

    //injuction classes
    //@Autowired tells Spring, “I need this object here; please provide the appropriate Spring-managed instance.”
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
//@GetMapping - tells Spring Boot to execute this method when a matching HTTP GET request arrives.
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

    //GetMapping for One Customer
    @GetMapping("/getCustomers/{id}")
    public List<Customer> getCustomers(@PathVariable Long id){
        System.out.println("Inside getCustmers to get one value of id. ---" + id);
        return customerService.getCustomers(id);
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@RequestBody Customer customer) {
        System.out.println("Inside create customer"+customer);
       return customerService.createCustomer(customer);

    }

    @PutMapping("/updateCustomer")
    public String updateCustomer(@RequestBody Customer customer) {
        System.out.println("Inside create customer"+customer);
        return customerService.updateCustomer(customer);
    }


    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable long id){
        System.out.println("inside delete resp api call method");
        //List<Customer> deletedCustomer = customerService.getOneCustomer(id);
        return customerService.deleteCustomer(id);

    }

    @GetMapping("/getGroupByEmail")
        public HashMap<String,ArrayList<Customer>> getGroupByEmail(){
            System.out.println("fetching group data");

            return customerService.getGroupByEmail();
        }



}
