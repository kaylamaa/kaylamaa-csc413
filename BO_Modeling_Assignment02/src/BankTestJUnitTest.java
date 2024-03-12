/*************************************************
 File: BankTestJUnitTest.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Testing the JUnit to test my
 objects
 *************************************************/
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.PriorityQueue;

import java.util.Date;

public class BankTestJUnitTest {

    @Test
    public void testCustomer() {
        Customer customer = new Customer("921804894", "Kayla Maa", "kaylamaa@example.com", Role.CUSTOMER);

        assertAll("customer",
                () -> assertEquals("921804894", customer.getId()),
                () -> assertEquals("Kayla Maa", customer.getName()),
                () -> assertEquals("kaylamaa@example.com", customer.getEmail()),
                () -> assertEquals(Role.CUSTOMER, customer.getRole())
        );
    }

    @Test
    public void testAccount() {
        Date creationDate = new Date();
        Account account = new Account("921804894", "921804894", "Checking", 500.0, creationDate);

        assertAll("account",
                () -> assertEquals("921804894", account.getId()),
                () -> assertEquals("921804894", account.getCustomerId()),
                () -> assertEquals("Checking", account.getType()),
                () -> assertEquals(500.0, account.getBalance()),
                () -> assertEquals(creationDate, account.getCreationDate())
        );
    }

    @Test
    public void testTransaction() {
        Date timestamp = new Date();
        Transaction transaction = new Transaction("1", "1", "Deposit", 500.0, timestamp);

        assertAll("transaction",
                () -> assertEquals("1", transaction.getId()),
                () -> assertEquals("1", transaction.getAccountId()),
                () -> assertEquals("Deposit", transaction.getType()),
                () -> assertEquals(500.0, transaction.getAmount()),
                () -> assertEquals(timestamp, transaction.getTimestamp())
        );
    }

    @Test
    public void testPriorityQueue() {
        PriorityQueue<Account> pq = new PriorityQueue<>();

        // Assuming Account class implements Comparable or you provide a Comparator
        Account acc1 = new Account("1", "123", "Checking", 1000.0, new Date(120, 0, 1));
        Account acc2 = new Account("2", "456", "Savings", 1500.0, new Date(119, 0, 1));
        Account acc3 = new Account("3", "789", "Checking", 2000.0, new Date(121, 0, 1));

        pq.add(acc1);
        pq.add(acc2);
        pq.add(acc3);

        assertEquals(acc2, pq.remove());
        assertEquals(acc1, pq.remove());
        assertEquals(acc3, pq.remove());
    }

    @Test
    public void testTeller() {
        Teller teller = new Teller("222", "Marcos", "marcos@example.com", Role.TELLER);

        assertAll("teller",
                () -> assertEquals("222", teller.getId(), "Teller ID must be the same"),
                () -> assertEquals("Marcos", teller.getName(), "Teller name must be the same"),
                () -> assertEquals(Role.TELLER, teller.getRole(), "Error: Teller role should be Teller.")
        );
    }

    @Test
    public void testUpdateAndAuthenticate() {
        Security security = new Security("username", "pass");

        // Test initial authentication
        assertTrue(security.validate("username", "pass"), "Valid entry.");

        // Update credentials
        security.updateAccountDetails("newUser", "newPass");

        // Test authentication with old credentials
        assertFalse(security.validate("user", "pass"), "Valid entry of old user/pass.");

        // Test authentication with new credentials
        assertTrue(security.validate("newUser", "newPass"), "Valid new entry. ");
    }

    @Test
    public void testSecurity() {
        Security security = new Security("testUser", "testPass");

        assertEquals("testUser", security.getUsername(), "Username getter should return the correct username");
        assertEquals("testPass", security.getPassword(), "Password getter should return the correct password");
    }
}