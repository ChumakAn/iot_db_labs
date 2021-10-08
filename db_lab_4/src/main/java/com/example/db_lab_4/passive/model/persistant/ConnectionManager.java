package com.example.db_lab_4.passive.model.persistant;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {


    private static final String URL = "jdbc:mysql://localhost:3306/student_project?allowPublicKeyRetrieval=true&" +
            "createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection = null;

    private ConnectionManager() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            }
        }
        return connection;
    }
}