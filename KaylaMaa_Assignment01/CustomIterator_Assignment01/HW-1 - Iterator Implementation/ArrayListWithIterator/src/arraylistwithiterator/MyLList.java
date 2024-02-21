/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package listtest;
package listtest.arraylistwithiterator;

import java.util.*;
//import queuetest.LinkedQueue;

/**
 *
 * @author kmehta
 */
public class MyLList<E> implements ListInterface<E> {
    public Node firstNode;
    private int numberOfEntries;

    public MyLList() {
        clear();
    }

    public void add(E newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.next = newNode;
        }
        numberOfEntries++;
    }

    public boolean add(int givenPosition, E newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);
            if (givenPosition == 1) {
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node previousNode = getNodeAt(givenPosition - 1);
                newNode.next = previousNode.next;
                previousNode.next = newNode;
            }
            numberOfEntries++;
            return true;
        } else {
            return false;
        }
    }

    public E remove(int givenPosition) {
        E result = null;
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            if (givenPosition == 1) {
                result = firstNode.data;
                firstNode = firstNode.next;
            } else {
                Node previousNode = getNodeAt(givenPosition - 1);
                result = previousNode.next.data;
                previousNode.next = previousNode.next.next;
            }
            numberOfEntries--;
            return result;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
        }
    }

    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    }

    public E replace(int givenPosition, E newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node nodeToReplace = getNodeAt(givenPosition);
            E originalEntry = nodeToReplace.data;
            nodeToReplace.data = newEntry;
            return originalEntry;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
        }
    }

    public E getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            return getNodeAt(givenPosition).data;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
        }
    }

    public E[] toArray() {
        @SuppressWarnings("unchecked")
        E[] result = (E[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while (currentNode != null) {
            result[index] = currentNode.data;
            currentNode = currentNode.next;
            index++;
        }
        return result;
    }

    public boolean contains(E anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data)) {
                found = true;
            }
            currentNode = currentNode.next;
        }
        return found;
    }

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    private Node getNodeAt(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            Node currentNode = firstNode;
            for (int i = 1; i < givenPosition; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        } else {
            throw new IndexOutOfBoundsException("Illegal position given to getNodeAt operation.");
        }
    }
    public class Node {
        public E data;
        public Node next;

        public Node(E data) {
            this(data, null);
        }

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
