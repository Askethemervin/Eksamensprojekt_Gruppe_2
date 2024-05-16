package com.example.eksamenprojekt_gruppe_2.Repository;

import com.example.eksamenprojekt_gruppe_2.Model.Damages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DamagesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final class DamageRowMapper implements RowMapper<Damages> {

        @Override
        public Damages mapRow(ResultSet rs, int rowNum) throws SQLException {
            Damages damage = new Damages();
            damage.setId(rs.getInt("id"));
            damage.setDamageReportId(rs.getInt("damageReportId"));
            damage.setDamageDescription(rs.getString("damageDescription"));
            damage.setPrice(rs.getDouble("price"));
            return damage;
        }
    }

    // create
    public void save (Damages damage){
       String sql = "INSERT INTO damages (damageReportId, damageDescription, price) VALUES (?, ?, ?)";
       jdbcTemplate.update(sql, damage.getDamageReportId(), damage.getDamageDescription(), damage.getPrice());
    }

    // read
    public Damages findById(int id){
        String sql = "SELECT * FROM damages WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new DamageRowMapper(), id);
    }

    // update
    public void update (Damages damage) {
        String sql = "UPDATE damages SET rentalAgreementId = ?, damageDescription = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, damage.getDamageReportId(), damage.getDamageDescription(), damage.getPrice(), damage.getId());
    }

    // Delete
    public void deleteById(int id) {
        String sql = "DELETE FROM damages WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // List all
    public List<Damages> findAll(){
        String sql = "SELECT * FROM damages";
        return jdbcTemplate.query(sql, new DamageRowMapper());
    }
}
