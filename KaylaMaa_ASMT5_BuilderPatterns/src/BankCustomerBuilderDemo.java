/*************************************************
 File: BankCustomerBuilderDemo.java
 By: Kayla Maa
 Date: 04/20/2024
 Compile: Run
 Description: Testing the Demo Class for the
 Customer Builder
 *************************************************/
public class BankCustomerBuilderDemo {
    public static void main(String[] args) {
        // Creating a Customer object that will
        // test the builder() that we have created in
        // BankCustomer.java
        BankCustomer customer = new BankCustomer.BankCustomerBuilder()
                .buildWithUsername("kaylamaa")
                .buildWithEmail("kaylamssm@gmail.com")
                .buildWithPhone("415-223-2322")
                .buildWithSex('F')
                .buildWithBirthday("04-11-2003")
                .buildWithDepartment("Sales")
                .buildWithId(921804894)
                .buildWithFirstName("Kayla")
                .buildWithLastName("Maa")
                .build();

        BankCustomer customer1 = new BankCustomer.BankCustomerBuilder()
                .buildWithUsername("santiagosm1998")
                .buildWithEmail("santiagosm1998@gmail.com")
                .buildWithPhone("415-344-2334")
                .buildWithSex('M')
                .buildWithBirthday("11-21-1998")
                .buildWithDepartment("Management")
                .buildWithId(48384812)
                .buildWithFirstName("Marcos")
                .buildWithLastName("Solorzano")
                .build();

        System.out.println(customer + "\n\n" + customer1);
    }
}
