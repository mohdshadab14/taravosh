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
//above final variable value is coming from the file path. the resourceToString read the path as variable and return output
    private final String SELECT_ONE_CUSTOMER = MapperUtil.resourceToString("/sql/selectCustomerOnCondition");
    private  static String CREATE_CUSTOMERS = MapperUtil.resourceToString("/sql/createCustomer.sql");
    private final String DELETE_CUSTOMER = MapperUtil.resourceToString("/sql/deleteCustomer.sql");

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

    public List<Customer> getOneCustomer(long id){
        return jdbc.query(SELECT_ONE_CUSTOMER,
                customerMapper, id);
 }

public List<Customer> createCustomer(Customer customer){
    System.out.println("inside repository - create customer");
    //System.out.println("CREATE_CUSTOMERS"+CREATE_CUSTOMERS);
    return jdbc.query(
           CREATE_CUSTOMERS,
           customerMapper,
           customer.getFirstName(),
           customer.getLastName(),
           customer.getEmail(),
           customer.getPhoneNumber()
           );
}

public List<Customer> deleteCustomer(long id){
    System.out.println("INSIDE DELETE - repository");
    return jdbc.query(
            DELETE_CUSTOMER,
            customerMapper,
            id);
}
}
