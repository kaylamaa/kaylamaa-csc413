/*************************************************
 File: Customer.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the Customer Class
 *************************************************/
public class Customer implements UserPermissions {
    private String id;
    private String name;
    private String email;
    private Role role;

    // will impplement in the future, but creating method for now
        @Override
        public void viewAccountDetails() {
            System.out.println("Customer viewing their account details.");
        }
    // is not the final transaction, just making sure for future reference
        @Override
        public void performTransaction() {
            System.out.println("Customer performing a transaction.");
        }

    @Override
    public void assistCustomer() {
        System.out.println();
    }

    // Constructor with parameters
    public Customer(String id, String name, String email, Role role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }
    //Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Customer Details:\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Email: " + email + "\n" +
                "Role: " + role;
    }
}

