package com.example.eksamenprojekt_gruppe_2.Repository;

import com.example.eksamenprojekt_gruppe_2.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer";
        RowMapper<Customer> customerRowMapper= new BeanPropertyRowMapper<Customer>(Customer.class);
        return jdbcTemplate.query(sql, customerRowMapper);
    }
    public void addCustomer(Customer customer){
        String sql = "INSERT INTO customer (first_name, last_name, driverslicense_number) VALUES (?,?,?)";
        jdbcTemplate.update(sql, customer.getFirst_name(), customer.getLast_name(), customer.getDriverslicense_number());
    }
}
