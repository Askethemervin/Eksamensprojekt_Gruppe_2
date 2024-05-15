package com.example.eksamenprojekt_gruppe_2.Repository;


import com.example.eksamenprojekt_gruppe_2.Model.RentalAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RentalAgreementRepository {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public RentalAgreementRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }
    public List<RentalAgreement> findAll() {
        String sql = "SELECT * FROM rentalagreements";
        RowMapper<RentalAgreement> rentalAgreementRowMapper= new BeanPropertyRowMapper<>(RentalAgreement.class);
        return jdbcTemplate.query(sql, rentalAgreementRowMapper);
    }
    public void addRentalAgreement(RentalAgreement rentalAgreement) {
        String sql = "INSERT INTO rentalagreements (rental_type, duration, price) VALUES (?,?,?)";
        jdbcTemplate.update(sql, rentalAgreement.getType(),rentalAgreement.getDuration(),rentalAgreement.getPrice());
    }

}
