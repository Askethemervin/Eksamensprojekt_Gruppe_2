package com.example.eksamenprojekt_gruppe_2.Repository;

import com.example.eksamenprojekt_gruppe_2.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Finder alle biler i databasen
    public List<Car> findAll() {
        String sql = "SELECT * FROM cars";
        RowMapper<Car> carRowMapper = new BeanPropertyRowMapper<>(Car.class);
        return jdbcTemplate.query(sql,  carRowMapper);
    }

    // Finder alle biler, der er udlejet
    public List<Car> findRentedCars() {
        String sql = "SELECT * FROM cars WHERE vehiclestatus = 'rented'";
        RowMapper<Car> carRowMapper = new BeanPropertyRowMapper<>(Car.class);
        return jdbcTemplate.query(sql, carRowMapper);
    }

    // Finder alle biler, der er returneret
    public List<Car> findReturnedCars() {
        String sql = "SELECT * FROM cars WHERE vehiclestatus = 'returned'";
        RowMapper<Car> carRowMapper = new BeanPropertyRowMapper<>(Car.class);
        return jdbcTemplate.query(sql, carRowMapper);
    }

    // Opdaterer status for en bil
    public void updateCarStatus(int carId, String status) {
        String sql = "UPDATE cars SET vehiclestatus = ? WHERE vehiclenumber = ?";
        jdbcTemplate.update(sql, status, carId);
    }
}
