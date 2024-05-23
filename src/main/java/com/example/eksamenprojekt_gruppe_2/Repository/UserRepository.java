package com.example.eksamenprojekt_gruppe_2.Repository;

import com.example.eksamenprojekt_gruppe_2.Model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    // metoder vi ikke nåede at få implementeret.

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Henter alle brugere fra databasen
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    // Opretter en ny bruger i databasen
    public void createUser(User user) {
        String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getPassword());
    }

    // Validerer brugerens oplysninger
    public boolean isValidUser(String username, String password, HttpSession session) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, username, password);
        if (count == 1) {
            session.setAttribute("username", username);
            return true;
        }
        return false;
    }

    // Henter brugerens ID ved brugernavn
    public String getUserIdByUsername(String username) {
        return username;
    }
}
