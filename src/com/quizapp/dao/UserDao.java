package com.quizapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
    // Method to validate user credentials
    public boolean validateUser(String username, String password) {
        boolean isValid = false;

        // Database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/quiz_app";
        String dbUsername = "subramanyamavanapu"; 
        String dbPassword = "yaswanth@2006";     

        Connection con = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection to the database
            con = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword);

            // SQL query to validate the user
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // If a result is found, set isValid to true
            if (rs.next()) {
                isValid = true;
            }

        } catch (Exception e) {
            e.printStackTrace(); // Log the exception stack trace

        } finally {
            try {
                // Close the connection if it's open
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isValid;
    }
}
