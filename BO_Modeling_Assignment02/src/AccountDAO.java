/*************************************************
 File: AccountDAO.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the AccountDAO
 *************************************************/


import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {
    // Method to insert an account into the database
    int insert(Account account) throws SQLException;

    // Method to retrieve an account from the database by ID
    Account get(String accountId) throws SQLException;

    // Method to update an account in the database
    int update(Account account) throws SQLException;

    // Method to delete an account from the database
    int delete(Account account) throws SQLException;

//    void addAccount(AccountDTO account);
//    AccountDTO getAccount(String accountId);
//    void updateAccount(AccountDTO account);
//    void deleteAccount(String accountId);
//    List<AccountDTO> getAllAccounts();
}
