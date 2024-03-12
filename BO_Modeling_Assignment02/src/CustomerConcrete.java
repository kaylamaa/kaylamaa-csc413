/*************************************************
 File: CustomerConcrete.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the Customer DAO Concrete
 *************************************************/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerConcrete implements CustomerDAO {

    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    // Assuming CustomerDataConnection provides methods for DB connection and SQL queries
    static String url = CustomerDataConnection.getURL();
    static String username = CustomerDataConnection.getUsername();
    static String password = CustomerDataConnection.getPassword();

    CustomerConcrete() {
        try {
            connection = CustomerDataConnection.getDBConnection();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

    // disconnecting from DB
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // add customer to the DB
    @Override
    public int insert(CustomerDTO customer) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement(CustomerDataConnection.getInsertSQL());
        pStatement.setString(1, customer.getId());
        pStatement.setString(2, customer.getName());
        pStatement.setString(3, customer.getEmail());
        // Assuming these are the fields of Customer class
        res = pStatement.executeUpdate();
        disconnect();

        return res;
    }

    // get customer through DB
    @Override
    public CustomerDTO get(String customerId) throws SQLException {
        pStatement = connection.prepareStatement(CustomerDataConnection.getSelectSQL());
        pStatement.setString(1, customerId);
        result = pStatement.executeQuery();

        CustomerDTO customer = null;
        if (result.next()) {
            customer = new CustomerDTO(result.getString("id"), result.getString("name"), result.getString("email"), Role.valueOf(result.getString("role")));
            // Assuming constructor for CustomerDTO(String, String, String, Role)
        }

        return customer;
    }

    // Method to update a customer in the database
    @Override
    public int update(CustomerDTO customer) throws SQLException {
        int result = -1;
        pStatement = connection.prepareStatement(CustomerDataConnection.getUpdateSQL());
        pStatement.setString(1, customer.getName());
        pStatement.setString(2, customer.getEmail());
        pStatement.setString(3, customer.getRole().toString());
        pStatement.setString(4, customer.getId());
        result = pStatement.executeUpdate();

        return result;
    }

    // Method to delete a customer from the database
    @Override
    public int delete(String customerId) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement(CustomerDataConnection.getDeleteSQL());
        pStatement.setString(1, customerId);
        res = pStatement.executeUpdate();

        return res;
    }

    @Override
    public List<CustomerDTO> getAll() throws SQLException {
        List<CustomerDTO> customers = new ArrayList<>();
        pStatement = connection.prepareStatement(CustomerDataConnection.getSelectAllSQL()); // Assuming a getSelectAllSQL method exists
        result = pStatement.executeQuery();

        while (result.next()) {
            customers.add(new CustomerDTO(result.getString("id"), result.getString("name"), result.getString("email"), Role.valueOf(result.getString("role"))));
        }

        return customers;
    }
}
