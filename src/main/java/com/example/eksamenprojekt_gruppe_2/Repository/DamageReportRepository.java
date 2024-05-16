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
public class DamageReportRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DamageReportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class DamageReportRowMapper implements RowMapper<DamageReport> {
        @Override
        public DamageReport mapRow(ResultSet rs, int rowNum) throws SQLException {
            DamageReport damageReport = new DamageReport();
            damageReport.setId(rs.getInt("id"));
            damageReport.setRentalAgreementId(rs.getInt("rentalAgreementId"));
            // Set andre egenskaber for skadesrapporten
            return damageReport;
        }
    }

    public void save(DamageReport damageReport) {
        String sql = "INSERT INTO DamageReports (rentalAgreementId) VALUES (?)";
        jdbcTemplate.update(sql, damageReport.getRentalAgreementId());
    }

    public DamageReport findById(int id) {
        String sql = "SELECT * FROM DamageReports WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new DamageReportRowMapper(), id);
    }

    // Implementer metoder til opdatering, sletning og andre operationer efter behov
}
