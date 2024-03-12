/*************************************************
 File: AccountDTO.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the Account DTO
 *************************************************/
public class AccountDTO {

    private String id;
    private String customerId;
    private String type;
    private double balance;

    public AccountDTO() {}

    public AccountDTO(String id, String customerId, String type, double balance) {
        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.balance = balance;
    }

    // Getters and Setters
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
}
