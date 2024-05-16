package com.example.eksamenprojekt_gruppe_2.Repository;

import com.example.eksamenprojekt_gruppe_2.Model.DamageReport;
import org.springframework.beans.factory.annotation.Autowired;
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

    // read
    public DamageReport findById(int id){
        String sql = "SELECT * FROM damagereport WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new DamageReportRowMapper(), id);
    }

    // update
    public void update (DamageReport damageReport) {
        String sql = "UPDATE damagereport SET rentalAgreementId = ?, damageDescription = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, damageReport.getRentalAgreementId(), damageReport.getDamageDescription(), damageReport.getPrice(), damageReport.getId());
    }

    // Delete
    public void deleteById(int id) {
        String sql = "DELETE FROM damagereport WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // List all
    public List<DamageReport> findAll(){
        String sql = "SELECT * FROM damagereport";
        return jdbcTemplate.query(sql, new DamageReportRowMapper());
    }
}