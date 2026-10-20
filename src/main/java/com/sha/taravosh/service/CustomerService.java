package com.sha.taravosh.service;

import com.sha.taravosh.model.Customer;
import com.sha.taravosh.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    //private final JdbcTemplate jdbc;

    public List<Customer> getCustomers() {

        return customerRepository.getCustomers();
    }

    public List<Customer> getCustomers(Long id){
        System.out.println("value"+id);
        //return customerRepository.getCustomers();
        return customerRepository.getOneCustomer(id);
    }

   /* public void createCustomer(Customer customer) {
        jdbc.update(
                "INSERT INTO customer (first_name, last_name, email, phone) VALUES (?, ?, ?, ?)",
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }*/
    public String createCustomer(Customer customer){
        System.out.println("INSIDE CREATE CUSTOMER");
        return customerRepository.createCustomer(customer);

     }

    public String updateCustomer(Customer customer){
        System.out.println("Update CUSTOMER");
        return customerRepository.updateCustomer(customer);

    }


     public String deleteCustomer(long id){
         System.out.println("Inside delete customer - customer service");
         return customerRepository.deleteCustomer(id);
     }

}
