package com.example.eksamenprojekt_gruppe_2.Repository;


import com.example.eksamenprojekt_gruppe_2.Model.RentalAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class RentalAgreementRepository {

    private final JdbcTemplate jdbcTemplate;

    // Mapper til at konvertere rows fra databasen til RentalAgreement-objekter
    private static final class RentalAgreementRowMapper implements RowMapper<RentalAgreement> {
        @Override
        public RentalAgreement mapRow(ResultSet rs, int rowNum) throws SQLException {
            RentalAgreement rentalAgreement = new RentalAgreement();
            rentalAgreement.setId(rs.getInt("RentalAgreement_ID"));
            rentalAgreement.setRental_type(rs.getString("rental_type"));
            rentalAgreement.setDuration(rs.getInt("duration"));
            rentalAgreement.setPrice(rs.getInt("price"));
            rentalAgreement.setCar_id(rs.getInt("car_id"));
            rentalAgreement.setCustomer_id(rs.getInt("customer_id"));
            return rentalAgreement;
        }
    }
    // Konstruktør til at initialisere JdbcTemplate
    @Autowired
    public RentalAgreementRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    // Finder alle lejeaftaler i databasen
    public List<RentalAgreement> findAll() {
        String sql = "SELECT * FROM rentalagreements";
        RowMapper<RentalAgreement> rentalAgreementRowMapper= new BeanPropertyRowMapper<>(RentalAgreement.class);
        return jdbcTemplate.query(sql, rentalAgreementRowMapper);
    }

    // Tilføjer en ny lejeaftale til databasen
    public void addRentalAgreement(RentalAgreement rentalAgreement) {
        String sql = "INSERT INTO rentalagreements (rental_type, duration, price, car_id, customer_id) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, rentalAgreement.getRental_type(),rentalAgreement.getDuration(),rentalAgreement.getPrice(),rentalAgreement.getCar_id(), rentalAgreement.getCustomer_id());
    }

    // Finder en lejeaftale baseret på dens ID
    public RentalAgreement findById(int id) {
        try {
            String sql = "SELECT * FROM rentalagreements WHERE RentalAgreement_ID = ?";
            return jdbcTemplate.queryForObject(sql, new RentalAgreementRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null; // Returnerer null, hvis lejeaftalen ikke blev fundet
        }
    }
}
