package listtest.arraylistwithiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListWithIterator<E> extends MyLList<E> implements ListWithIteratorInterface<E> {

    public LinkedListWithIterator() {
        super();
    }

    public Iterator<E> getIterator() {
        return new IteratorForLinkedList();
    }

    public Iterator<E> iterator() {
        return getIterator();
    }

    private class IteratorForLinkedList implements Iterator<E> {
        private Node nextNode;          // Next node to return
        private boolean wasNextCalled;  // Needed by remove

        private IteratorForLinkedList() {
            nextNode = firstNode;
            wasNextCalled = false;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public E next() {
            if (hasNext()) {
                wasNextCalled = true;
                E nextEntry = nextNode.data;
                nextNode = nextNode.next;  // Advance iterator

                return nextEntry;
            } else {
                throw new NoSuchElementException("Illegal call to next(); iterator is after the end of the list.");
            }
        }

        public void remove() {
            if (wasNextCalled) {
                Node previousNode = lookingAtPreviousNode(nextNode);

                if (previousNode != null) {
                    previousNode.next = nextNode.next;
                    wasNextCalled = false;   // Reset flag
                } else {
                    // If previousNode is null, it means nextNode is the firstNode
                    // Update firstNode to the next node
                    firstNode = nextNode.next;
                    wasNextCalled = false;   // Reset flag
                }
            } else {
                throw new IllegalStateException("Illegal call to remove(); next() was not called.");
            }
        }
        private Node lookingAtPreviousNode(Node targetNode) {
            Node currentNode = firstNode;

            while (currentNode != null && currentNode.next != targetNode) {
                currentNode = currentNode.next;
            }

            return currentNode;
        }
    }
}