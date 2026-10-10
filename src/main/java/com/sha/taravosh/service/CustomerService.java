package com.sha.taravosh.service;

import com.sha.taravosh.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

@Service
public class CustomerService {

    private final JdbcTemplate jdbc;

    public CustomerService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    private final RowMapper<Customer> customerMapper = (rs, rowNum) -> {
        Customer c = new Customer();
        c.setId(rs.getLong("id"));
        c.setFirstName(rs.getString("first_name"));
        c.setLastName(rs.getString("last_name"));
        c.setEmail(rs.getString("email"));
        c.setPhoneNumber(rs.getString("phone"));
        c.setCreatedAt(rs.getTimestamp("created_at"));
        return c;
    };

    public List<Customer> getCustomers() {

        return jdbc.query(
                "SELECT id, first_name, last_name, email, phone, created_at FROM customer ORDER BY id",
                customerMapper
        );
    }

    public void createCustomer(Customer customer) {
        jdbc.update(
                "INSERT INTO customer (first_name, last_name, email, phone) VALUES (?, ?, ?, ?)",
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    }
    public int deleteCustomer(long id) {

        return jdbc.update("DELETE FROM customer WHERE id = ?", id);
    }

    public List<Customer> getCustomers (long id){
        List<Customer> result = jdbc.query("select * from customer where id = ?", customerMapper, id);
        return result;
    }


}
