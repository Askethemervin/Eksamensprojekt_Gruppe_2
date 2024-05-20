package com.example.eksamenprojekt_gruppe_2.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class LoginValidation {
    public static void main(String[] args) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/YOUR_DATABASE");
        dataSource.setUsername("username");
        dataSource.setPassword("password");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String username = "username";
        String password = "password";

        String sql = "SELECT COUNT(*) FROM users WHERE username=? AND password=?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, username, password);

        if (count > 0) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }
    }
}