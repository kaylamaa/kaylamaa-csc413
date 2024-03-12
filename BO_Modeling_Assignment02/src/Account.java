/*************************************************
 File: Account.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the Account class
 *************************************************/


import java.util.Date;

public class Account implements Comparable<Account> {
    private String id;
    private String customerId;
    private String type;
    private double balance;
    private Date creationDate;

    // Default constructor
    public Account() {
    }

    // Constructor with parameters
    public Account(String id, String customerId, String type, double balance, Date creationDate) {
        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.balance = balance;
        this.creationDate = creationDate;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > this.balance) {
            throw new IllegalArgumentException("Unable to withdraw amount that is more than balance.");
        }
        this.balance -= amount;
    }

    // Implement compareTo for PriorityQueue based on creationDate and balance
    @Override
    public int compareTo(Account other) {
        // First compare by creationDate
        int dateCompare = this.creationDate.compareTo(other.creationDate);
        if (dateCompare != 0) {
            return dateCompare;
        }
        // If dates are the same, compare by balance (higher balance has priority)
        return Double.compare(other.balance, this.balance); // Note: For descending order
    }


    // Override toString() method for easy printing
    @Override
    public String toString() {
        return "Account: " +
                "Id= " + id + '\n' +
                "Customer Id= " + customerId + '\n' +
                "Account Type= " + type + '\n' +
                "Balance= " + balance + '\n' +
                "Creation  Date=" + creationDate +
                '\n';
    }
}