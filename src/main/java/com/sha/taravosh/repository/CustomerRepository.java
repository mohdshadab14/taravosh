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
    private final static String SELECT_ONE_CUSTOMER = MapperUtil.resourceToString("/sql/selectCustomerOnCondition.sql");
    private final static String CREATE_CUSTOMERS = MapperUtil.resourceToString("/sql/createCustomer.sql");
    private final static String DELETE_CUSTOMER = MapperUtil.resourceToString("/sql/deleteCustomer.sql");
    private final static String UPDATE_CUSTOMER = MapperUtil.resourceToString("/sql/updateCustomer.sql");
    private final static String CUSTOMER_GROUP = MapperUtil.resourceToString("/sql/groupbyCustomer.sql");
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
        System.out.println("SELECT_ALL_CUSTOMERS"+SELECT_ALL_CUSTOMERS);
        return jdbc.query(SELECT_ALL_CUSTOMERS,
                customerMapper
        );
    }

    public List<Customer> getOneCustomer(Long id){
        System.out.println("SELECT_ONE_CUSTOMER"+SELECT_ONE_CUSTOMER);
        return jdbc.query(SELECT_ONE_CUSTOMER,
                customerMapper, id.longValue());

 }
/*
public void createCustomer(Customer customer){
    System.out.println("inside repository - create customer");
    //System.out.println("CREATE_CUSTOMERS"+CREATE_CUSTOMERS);
    //jdbc.execute(CREATE_CUSTOMERS);
     jdbc.query(
           CREATE_CUSTOMERS,
           customerMapper,
           customer.getFirstName(),
           customer.getLastName(),
           customer.getEmail(),
           customer.getPhoneNumber()
           );
}
*/
    public String createCustomer(Customer customer) {
        System.out.println("inside repository - create customer");
    try{
        jdbc.update(
                CREATE_CUSTOMERS,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber()
        );
    } catch (RuntimeException e) {
         return "Failed to create Customer --- "+e.getMessage();
    }
        return "Customer record created";
    }

    public String updateCustomer(Customer customer) {
        System.out.println("inside repository - create customer");
        try{
            jdbc.update(
                    UPDATE_CUSTOMER,
                    customer.getFirstName(),
                    customer.getId()
            );
        } catch (RuntimeException e) {
            return "Failed to update Customer --- "+e.getMessage();
        }
        return "Customer record updated";
    }


    public String deleteCustomer(long id) {
        System.out.println("INSIDE DELETE - repository");
        try {
            jdbc.update(
                    DELETE_CUSTOMER,
                    id
            );
        } catch (RuntimeException e) {
            return "Failed to delete Customer --- " + e.getMessage();
        }
        return "Customer record deleted";
    }
    public List<Customer> groupbyCustomer() {
        System.out.println("inside repository - GROU BY customer");

            return jdbc.query(
                    CUSTOMER_GROUP,
                    customerMapper
            );
    }

}
