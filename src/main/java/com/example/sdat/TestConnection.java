package com.example.sdat;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/sdat_db?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "new_secure_password"; // use your real password here

        try {
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("✅ JDBC connection successful!");
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ JDBC connection failed: " + e.getMessage());
        }
    }
}