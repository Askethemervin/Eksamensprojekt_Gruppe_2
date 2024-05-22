package com.example.eksamenprojekt_gruppe_2.Repository;

import com.example.eksamenprojekt_gruppe_2.Model.DamageReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DamageRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final class DamageReportRowMapper implements RowMapper<DamageReport> {

        @Override
        public DamageReport mapRow(ResultSet rs, int rowNum) throws SQLException {
            DamageReport damageReport = new DamageReport();
            damageReport.setId(rs.getInt("id"));
            damageReport.setRentalAgreementId(rs.getInt("rentalAgreementId"));
            damageReport.setDamageDescription(rs.getString("damageDescription"));
            damageReport.setPrice(rs.getDouble("price"));
            return damageReport;
        }
    }

    // create
    public void save (DamageReport damageReport){
        String sql = "INSERT INTO damagereport (rentalAgreementId, damageDescription, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, damageReport.getRentalAgreementId(), damageReport.getDamageDescription(), damageReport.getPrice());
    }

    public List<DamageReport> loadDamageReport(int lejeaftale_id) {
        String sql = "SELECT * FROM damagereport WHERE rentalAgreementId = ? ORDER BY id";
        return jdbcTemplate.query(sql, new Object[]{lejeaftale_id}, new DamageReportRowMapper());
    }
}