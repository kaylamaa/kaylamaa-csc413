/*************************************************
 File: Security.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Attempting to create a security class
 *************************************************/
public class Security {
    private String username;
    private String password;

    // Constructor to initialize username and password
    public Security(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Update username and password
    public void updateAccountDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
