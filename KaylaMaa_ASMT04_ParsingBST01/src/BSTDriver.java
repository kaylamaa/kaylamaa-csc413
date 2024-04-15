/*************************************************
 File: BSTDriver.java
 By: Kayla Maa
 Date: 04/15/24
 Compile: Run
 Description: Testing the BST and checking if our
 methods are working properly.
 *************************************************/

public class BSTDriver {
    public static void main(String[] args) {
        BST bst = new BST();
        System.out.println("\nTesting our Binary Search Tree...");
        System.out.println("\n-------------------------------------------------------------");

        // Insert elements into the tree
        int[] elements = {80, 45, 20, 11, 60, 95, 35};
        System.out.println("Inserting elements into the tree:\n");
        for (int element : elements) {
            System.out.println(element + " has been inserted.");
            bst.insert(element);
        }

        System.out.println("-------------------------------------------------------------");
        // Displays the tree traversals
        System.out.println("\nInorder traversal of the BST:");
        bst.inorder();
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("\nPreorder traversal of the BST:");
        bst.preorder();
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("\nPostorder traversal of the BST:");
        bst.postorder();
        System.out.println("\n-------------------------------------------------------------");

        // Delete an element from the tree
        System.out.println("\nDeleting element 11 from the tree.");
        bst.delete(11);
        System.out.println("\n-------------------------------------------------------------");

        System.out.println("Inorder traversal after deletion:");
        bst.inorder();
        System.out.println("\n-------------------------------------------------------------");
        // Search for a specific element in a tree
        System.out.println("\nSearching for element 60 in the tree:");
        boolean found = bst.search(60);
        System.out.println("Element 60 is " + (found ? "found" : "not found") + " in the tree.");
        System.out.println("\n-------------------------------------------------------------");
        System.out.println("End of test...");
    }
}
