package com.sha.taravosh.service;

import com.sha.taravosh.model.Customer;
import com.sha.taravosh.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
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

    public HashMap<String,ArrayList<Customer>> getGroupByEmail(){
        System.out.println("Inside get by email - service");
        List<Customer> customersList = customerRepository.getCustomers();
        return constructGroupByEmailresponse(customersList);
    }
    //Bring the manupulation to separate method - create new method with parameters List<Customer>
    private HashMap<String,ArrayList<Customer>> constructGroupByEmailresponse(List<Customer> customerList){
        HashMap<String,ArrayList<Customer>> customersMap = new HashMap<>();
        //for each element c of Customer in customerlist

        for(Customer c:customerList){
            String email = c.getEmail();
            String domain = email.substring(email.lastIndexOf("@") + 1)
                    .toLowerCase();
            //ArrayList<Customer> customerDetails = new ArrayList<>();
            if(customersMap.containsKey(domain)){
              ArrayList<Customer> result =  customersMap.get(domain);
              result.add(c);
            }else{
                ArrayList<Customer> customerDetails = new ArrayList<>();
                customerDetails.add(c);
                customersMap.put(domain,customerDetails);
            }
//
        }
        System.out.println("customersMap----" + customersMap);
        return customersMap;
    }



}
