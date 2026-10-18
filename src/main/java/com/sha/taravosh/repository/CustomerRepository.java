package com.sha.taravosh.repository;

import com.sha.taravosh.model.Customer;
import com.sha.taravosh.util.MapperUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    private final JdbcTemplate jdbc;
    public CustomerRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final static String SELECT_ALL_CUSTOMERS = MapperUtil.resourceToString("/sql/selectAllCustomers.sql");


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


    public List<Customer> getCustomers(){
        return jdbc.query(SELECT_ALL_CUSTOMERS,
                customerMapper
        );
    }
}
