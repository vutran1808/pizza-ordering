/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class SQLConnection {
    private final static String url = "jdbc:sqlserver://localhost:1433;databaseName=pizza_ordering;encypt=true;trustServerCertificate=true";
    private final static String username = "sa";
    private final static String password = "admin123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
