/*************************************************
 File: Transaction.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the Transaction class
 *************************************************/
import java.util.Date;

public class Transaction {
    private String id;
    private String accountId;
    private String type;
    private double accountBalance;
    private Date timestamp;

    // Default constructor
    public Transaction() {}

    // Constructor with parameters
    public Transaction(String id, String accountId, String type, double amount, Date timestamp) {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.accountBalance = amount;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return accountBalance;
    }

    public void setAmount(double amount) {
        this.accountBalance = amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    // Override toString() method for easy printing
    @Override
    public String toString() {
        return "Transaction: \n" +
                "ID: " + id + '\n' +
                "Account Id= '" + accountId + '\n' +
                "Type= " + type + '\n' +
                "Amount= " + accountBalance + '\n' +
                "Timestamp= " + timestamp +
                '\n';
    }

    public void applyTransaction(Transaction transaction) {
        if ("Deposit".equals(transaction.getType())) {
            this.accountBalance += transaction.getAmount(); // Assuming 'balance' is a field in Account
        } else if ("Withdrawal".equals(transaction.getType())) {
            this.accountBalance -= transaction.getAmount();
        }
    }
}
