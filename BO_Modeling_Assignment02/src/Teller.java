/*************************************************
 File: Teller.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the Teller class
 *************************************************/
public class Teller {
    private String id;
    private String name;
    private Role role;

    public Teller(String id, String name, String email, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public void helpCustomer(Customer customer) {
        System.out.println("Assisting customer: " + customer.getName());
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "BankTeller Details:\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Role: " + role;
    }

}
