/*************************************************
 File: AccountDataConnection.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the Account Data Connection
 class
 *************************************************/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDataConnection {

    // JDBC URL, username, and password of MySQL server
    private static final String URL = ""; // implement later
    private static final String USERNAME = "root";
    private static final String PASSWORD = ""; // implement later

    // SQL queries for the Account entity
    private static final String INSERT_SQL = "INSERT INTO Account (id, customerId, type, balance, creationDate) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_SQL_BYID = "SELECT * FROM Account WHERE id = ?";
    private static final String UPDATE_SQL = "UPDATE Account SET customerId = ?, type = ?, balance = ?, creationDate = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM Account WHERE id = ?";

    public AccountDataConnection() { }

    public static Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Getter methods
    public static String getInsertSQL() {
        return INSERT_SQL;
    }

    public static String getSelectSQL() {
        return SELECT_SQL_BYID;
    }

    public static String getUpdateSQL() {
        return UPDATE_SQL;
    }

    public static String getDeleteSQL() {
        return DELETE_SQL;
    }

    // Getter methods for database credentials and URL
    public static String getURL() {
        return URL;
    }

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}
