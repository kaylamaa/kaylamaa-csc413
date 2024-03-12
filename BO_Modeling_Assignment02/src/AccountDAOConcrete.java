/*************************************************
 File: AccountDAOConcrete.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the Account DAO Concrete
 *************************************************/


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOConcrete implements AccountDAO {

    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    static String url = AccountDataConnection.getURL();
    static String username = AccountDataConnection.getUsername();
    static String password = AccountDataConnection.getPassword();

    AccountDAOConcrete() {
        try {
            connection = AccountDataConnection.getDBConnection();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

    // disconnect from DB
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // adding to the DB
    @Override
    public int insert(Account account) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement(AccountDataConnection.getInsertSQL());
        pStatement.setString(1, account.getId());
        pStatement.setString(2, account.getCustomerId());
        pStatement.setString(3, account.getType());
        pStatement.setDouble(4, account.getBalance());
        pStatement.setDate(5, new java.sql.Date(account.getCreationDate().getTime()));
        res = pStatement.executeUpdate();
        disconnect();

        return res;
    }

    @Override
    public Account get(String accountId) throws SQLException {
        pStatement = connection.prepareStatement(AccountDataConnection.getSelectSQL());
        pStatement.setString(1, accountId);
        result = pStatement.executeQuery();

        Account account = null;
        if (result.next()) {
            account = new Account(result.getString("id"), result.getString("customerId"), result.getString("type"),
                    result.getDouble("balance"), result.getDate("creationDate"));
            // Assuming a constructor in Account class that matches these parameters
        }

        return account;
    }

    // update the DB
    @Override
    public int update(Account account) throws SQLException {
        int result = -1;
        pStatement = connection.prepareStatement(AccountDataConnection.getUpdateSQL());
        pStatement.setString(1, account.getCustomerId());
        pStatement.setString(2, account.getType());
        pStatement.setDouble(3, account.getBalance());
        pStatement.setDate(4, new java.sql.Date(account.getCreationDate().getTime()));
        pStatement.setString(5, account.getId());
        result = pStatement.executeUpdate();

        return result;
    }

    @Override
    public int delete(Account account) throws SQLException {
        int res = -1;
        pStatement = connection.prepareStatement(AccountDataConnection.getDeleteSQL());
        pStatement.setString(1, account.getId());
        res = pStatement.executeUpdate();

        return res;
    }
}
