/*************************************************
 File: BST.java
 By: Kayla Maa
 Date: 04/15/24
 Compile: Run the BST Driver
 Description: Implementing functions that will be
 used to display and have a functioning BST
 *************************************************/
class BST {
    class Node {
        int value;
        Node left;
        Node right;

        public Node(int item) {
            value = item;
            left = right = null;
        }
    }

    Node root;

    // Setting the BST empty constructor
    BST() {
        root = null;
    }

    void insert(int value) {
        root = recursiveInsert(root, value);
    }
    // Accessible method that inserts value in tree
    Node recursiveInsert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = recursiveInsert(root.left, value);
        } else if (value > root.value) {
            root.right = recursiveInsert(root.right, value);
        }

        return root;
    }
    // Accessible method that deletes value in tree
    void delete(int value) {
        root = recursiveDelete(root, value);
    }

    Node recursiveDelete(Node root, int key) {
        if (root == null) return root;

        if (key < root.value)
            root.left = recursiveDelete(root.left, key);
        else if (key > root.value)
            root.right = recursiveDelete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.value = minValue(root.right);
            root.right = recursiveDelete(root.right, root.value);
        }

        return root;
    }

    // Helper method that helps find the minimum value of a subtree
    int minValue(Node root) {
        int mvalue = root.value;
        while (root.left != null) {
            mvalue = root.left.value;
            root = root.left;
        }
        return mvalue;
    }

    // Method to help find a specific value in the tree returning a boolean if found
    boolean search(int value) {
        return recursiveSearch(root, value) != null;
    }

    Node recursiveSearch(Node root, int value) {
        if (root == null || root.value == value) return root;

        if (root.value > value)
            return recursiveSearch(root.left, value);

        return recursiveSearch(root.right, value);
    }

    void inorder() {
        recursiveInorder(root);
    }
    //This method starts the logic of the inorder traversal of the tree
    void recursiveInorder(Node root) {
        if (root != null) {
            recursiveInorder(root.left);
            System.out.print(root.value + " ");
            recursiveInorder(root.right);
        }
    }

    void preorder() {
        recursivePreorder(root);
    }

    //This method starts the logic of the preorder traversal of the tree
    void recursivePreorder(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            recursivePreorder(root.left);
            recursivePreorder(root.right);
        }
    }

    void postorder() {
        recursivePostorder(root);
    }
    //This method starts the logic of the postorder traversal of the tree
    void recursivePostorder(Node root) {
        if (root != null) {
            recursivePostorder(root.left);
            recursivePostorder(root.right);
            System.out.print(root.value + " ");
        }
    }
}
