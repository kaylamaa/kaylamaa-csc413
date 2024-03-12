/*************************************************
 File: CustomerDataConnection.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the Data Connection for SQL
 *************************************************/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerDataConnection {

    // JDBC URL, username, and password of MySQL server
    private static final String URL = ""; // update
    private static final String USERNAME = "root";
    private static final String PASSWORD = ""; // update later

    private static final String INSERT_SQL = "INSERT INTO Customer (id, name, email, role) VALUES (?, ?, ?, ?)";
    private static final String SELECT_SQL_BY_ID = "SELECT * FROM Customer WHERE id = ?";
    private static final String SELECT_SQL_BY_EMAIL = "SELECT * FROM Customer WHERE email = ?";
    private static final String UPDATE_SQL = "UPDATE Customer SET name = ?, email = ?, role = ? WHERE id = ?";
    private static final String DELETE_SQL = "DELETE FROM Customer WHERE id = ?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM Customer";

    // Prevents instantiation
    private CustomerDataConnection() {}

    // Method to get a database connection
    public static Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // Getter methods for SQL queries
    public static String getInsertSQL() { return INSERT_SQL; }
    public static String getSelectSQLById() { return SELECT_SQL_BY_ID; }
    public static String getSelectSQLByEmail() { return SELECT_SQL_BY_EMAIL; }
    public static String getUpdateSQL() { return UPDATE_SQL; }
    public static String getDeleteSQL() { return DELETE_SQL; }
    public static String getSelectAllSQL() { return SELECT_ALL_SQL; } // To get all customers
    public static String getURL() { return URL; }
    public static String getUsername() { return USERNAME; }
    public static String getPassword() { return PASSWORD; }
    public static String getSelectSQL() { return SELECT_SQL_BY_ID;}
}
