/*************************************************
 File: PriorityQueue.java
 By: Kayla Maa
 Date: 03/11/2024
 Compile: Run
 Description: Creating the Priority Queue for Accounts
 *************************************************/
import java.util.LinkedList;

public class PriorityQueue implements PriorityQueueInterface<Account> {
        private LinkedList<Account> pq = new LinkedList<>();


    // Add an account to the queue based on priority logic
    public void add(Account account) {
        if (pq.isEmpty()) {
            pq.add(account);
        } else {
            boolean added = false;
            // Iterate through the queue to find the correct position for the new account
            for (int i = 0; i < pq.size(); i++) {
                if (account.compareTo(pq.get(i)) < 0) {
                    pq.add(i, account);
                    added = true;
                    break;
                }
            }
            // If the account has the lowest priority, add it to the end
            if (!added) {
                pq.addLast(account);
            }
        }
    }

    // Retrieve and remove the highest priority account
    @Override
    public Account poll() {
        if (!pq.isEmpty()) {
            return pq.poll();
        }
        return null; // or throw an exception based on your requirement
    }

    // Peek at the highest priority account without removing it
    @Override
    public Account peek() {
        return pq.peek();
    }

    // Get the size of the queue
    @Override
    public int size() {
        return pq.size();
    }

    public Account remove() {
        return pq.poll(); // Removes and returns the first element (highest priority)
    }

    // Check if the queue is empty
    @Override
    public boolean isEmpty() {
        return pq.isEmpty();
    }
}

