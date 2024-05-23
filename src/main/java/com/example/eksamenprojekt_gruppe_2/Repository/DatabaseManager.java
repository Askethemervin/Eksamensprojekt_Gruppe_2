package com.example.eksamenprojekt_gruppe_2.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class DatabaseManager {

    static DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        DatabaseManager.dataSource = dataSource;
    }

    // Metode vi brugte til at godkende bruger baseret på brugernavn og adgangskode i sidste projekt, som vi desværre ikke nåede at få implementeret.
    public static int authenticateUserByUsernameAndPassword(String username, String password) {
        try (Connection conn = dataSource.getConnection()) {
            // SQL-forespørgsel til at hente brugeroplysninger baseret på brugernavn og adgangskode
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Hvis brugeren findes, returneres deres ID
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Returner -1 hvis godkendelse mislykkes
        return -1;
    }
}


