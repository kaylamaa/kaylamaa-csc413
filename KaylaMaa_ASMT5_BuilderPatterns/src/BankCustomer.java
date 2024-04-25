/*************************************************
 File: BankCustomer.java
 By: Kayla Maa
 Date: 04/20/2024
 Compile: Run
 Description: Implementing and Init the Builder Class
 *************************************************/
public class BankCustomer {
    private String username;
    private String email;
    private String phone;
    private char sex;
    private String birthday;
    private String department;
    private int id;
    private String firstName;
    private String lastName;

    // Private constructor that the builder will use
    private BankCustomer(BankCustomerBuilder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.phone = builder.phone;
        this.sex = builder.sex;
        this.birthday = builder.birthday;
        this.department = builder.department;
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    // Creating the BankCustomer Builder class
    public static class BankCustomerBuilder {
        private String username;
        private String email;
        private String phone;
        private char sex;
        private String birthday;
        private String department;
        private int id;
        private String firstName;
        private String lastName;

        public BankCustomerBuilder buildWithUsername(String username) {
            this.username = username;
            return this;
        }

        public BankCustomerBuilder buildWithEmail(String email) {
            this.email = email;
            return this;
        }

        public BankCustomerBuilder buildWithPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public BankCustomerBuilder buildWithSex(char sex) {
            this.sex = sex;
            return this;
        }

        public BankCustomerBuilder buildWithBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public BankCustomerBuilder buildWithDepartment(String department) {
            this.department = department;
            return this;
        }

        public BankCustomerBuilder buildWithId(int id) {
            this.id = id;
            return this;
        }

        public BankCustomerBuilder buildWithFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public BankCustomerBuilder buildWithLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public BankCustomer build() {
            return new BankCustomer(this);
        }
    }

    @Override
    public String toString() {
        return "BankCustomer{\n FirstName= " + this.firstName
                + "\n LastName= " + this.lastName + "\n Customer ID= " + this.id + "\n Username= " + this.username + "\n Email= " + this.email
                + "\n Phone= " + this.phone + "\n Sex= " + this.sex + "\n Birthday= " + this.birthday
                + "\n Department= " + this.department + " }";
    }
}
