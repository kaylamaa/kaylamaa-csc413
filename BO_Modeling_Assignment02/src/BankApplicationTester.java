/*************************************************
 File: BankApplicationTester.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Testing to see if my tests are
 successful
 *************************************************/
import java.util.Date;
public class BankApplicationTester {

    public static void main(String[] args) {
        // Testing the important business objects
        testCustomer();
        testAccount();
        testTransaction();
        testPriorityQueue();
        testTeller();
    }

    private static void testCustomer() {
        System.out.println("----------------------------------------------");
        System.out.println("Checking Customer Class...");
        Customer customer = new Customer("921804894", "Kayla Maa", "kaylamaa@example.com", Role.CUSTOMER);

        boolean testPassed = customer.getId().equals("921804894") &&
                customer.getName().equals("Kayla Maa") &&
                customer.getEmail().equals("kaylamaa@example.com") &&
                customer.getRole() == Role.CUSTOMER;

        if (testPassed) {
            System.out.println("Customer class was successful.\n");
            System.out.println(customer.toString() + "\n");
            System.out.println("----------------------------------------------");
        } else {
            System.out.println("Customer class was unsuccessful.\n");
            System.out.println("----------------------------------------------");
        }
    }

    public static void testTeller() {
        System.out.println("----------------------------------------------");
        System.out.println("Checking Teller..");
        Teller teller = new Teller("3323", "Marcos Solozano", "marcos@example.com", Role.TELLER);

        // Create a sample Customer object for assistance testing
        Customer customer = new Customer("1233", "Kala Ma", "kalama@example.com", Role.CUSTOMER);

        // Test assisting a customer
        System.out.println("\nTesting assisting a customer:");
        teller.helpCustomer(customer);

        // Print Teller details
        System.out.println("\nTeller details:");
        System.out.println(teller);
    }

    private static void testAccount() {
        System.out.println("Checking the Account Class...");
        Date creationDate = new Date();
        Account account = new Account("921804894", "921804894", "Checking", 500.0, creationDate);

        boolean testPassed = account.getId().equals("921804894") &&
                account.getCustomerId().equals("921804894") &&
                account.getType().equals("Checking") &&
                account.getBalance() == 500.0 &&
                account.getCreationDate().equals(creationDate);

        if (testPassed) {
            System.out.println("Account class was successful.\n");
            System.out.println("----------------------------------------------");
        } else {
            System.out.println("Account class was unsuccessful.\n");
            System.out.println("----------------------------------------------");
        }
    }

    private static void testTransaction() {
        System.out.println("Checking Transaction Class...");
        Date timestamp = new Date();
        Transaction transaction = new Transaction("1", "1", "Deposit", 500.0, timestamp);

        boolean testPassed = transaction.getId().equals("1") &&
                transaction.getAccountId().equals("1") &&
                transaction.getType().equals("Deposit") &&
                transaction.getAmount() == 500.0 &&
                transaction.getTimestamp().equals(timestamp);

        if (testPassed) {
            System.out.println("Transaction class was successful.\n");
            System.out.println("----------------------------------------------");
        } else {
            System.out.println("Transaction class was unsuccessful.\n");
            System.out.println("----------------------------------------------");

        }
    }
    // Testing to see if the priority queue will work
    public static void testPriorityQueue() {
        PriorityQueue pq = new PriorityQueue();

        // Create Account instances
        Account acc1 = new Account("1", "123", "Checking", 1000.0, new Date(120, 0, 1));
        Account acc2 = new Account("2", "456", "Savings", 1500.0, new Date(119, 0, 1));
        Account acc3 = new Account("3", "789", "Checking", 2000.0, new Date(121, 0, 1));

        pq.add(acc1);
        pq.add(acc2);
        pq.add(acc3);

        // removing acc
        while (!pq.isEmpty()) {
            Account acc = pq.remove();
            System.out.println(acc.toString());
        }
    }


}