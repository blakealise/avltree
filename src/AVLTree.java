import java.util.ArrayList;
import java.util.List;

public class AVLTree {
    /**
     * Inner Node class representing each node in the AVL tree
     */
    int count = 0;
    private class Node {
        // TODO: Add instance variables for data, left child, right child, and height

        Node right;
        Node left;
        int height = 0;
        int data;

        /**
         * Constructor for Node
         * @param data the integer value to store in this node
         */
        public Node(int data) {
            // TODO: Initialize the node with the given data
            // TODO: Set left and right children to null
            // TODO: Initialize height (hint: a new leaf node has height 0)
            this.data = data;
            this.right = null;
            this.left = null;

        }
    }

    // Root of the AVL tree
    private Node root;

    /**
     * Constructor - creates an empty AVL tree
     */
    public AVLTree() {
        // TODO: Initialize root to null
    }

    // ==================== PUBLIC METHODS ====================

    public void insert(int data) {
        // TODO: Call the recursive helper method
        // TODO: Update root with the returned node
        root = insertHelper(data, root);
        count++;


    }
    public Node insertHelper(int data, Node node){

        if (node == null){
            Node ins = new Node(data);
            return ins;
        }

        if (data< node.data){
            node.left = insertHelper(data, node.left);
        }
        else{
            node.right = insertHelper(data,node.right);
        }

        /*
            Here is where the AVL magic happens
         */

        System.out.println(getBalanceFactor(node));

        if (getBalanceFactor(node) > 1){
            if(getBalanceFactor(node.left)>= 0){
                //right rotation
                node = rightRotation(node);
            }
            else{
                //left right rotation
                node = leftRotation(node);
                node = rightRotation(node);
            }
        }
        else if (getBalanceFactor(node) < -1){
            //right heavy
            if(getBalanceFactor(node.right)<=0){
                //left rotation
                node = leftRotation(node);
            }
            else{
                //right left rotation
                node = rightRotation(node);
                node = leftRotation(node);
            }
        }

        return node;
    }

    public Node rightRotation(Node node){
       Node newbie = node.left;
       node.left = newbie.right;
       newbie.right = node;
       return newbie;
    }
    public Node leftRotation(Node node){
        Node newbie = node.right;
        node.right = newbie.left;
        newbie.left = node;
        return newbie;
    }
    public void delete(int data) {
        // TODO: Call the recursive helper method
        // TODO: Update root with the returned node
        root = deleteHelp(root,data);
    }

    public Node deleteHelp (Node current, int value){
        System.out.println();
        if(current == null){
            return null;
        }
        if(current.data == value){
            System.out.println("Match found for deletion");
            count--;

            if(getNumOfChildren(current) == 0) { //Zero Children Case
                return null;
            }

            else if(getNumOfChildren(current) == 1) { //One Child Case
                System.out.println("one child");
                if(current.left == null){
                    return current.right;
                }
                if(current.right == null){
                    return current.left;
                }
            }

            else if(getNumOfChildren(current)==2) { //Two Children Case
                System.out.println("two children");
                Node replacement = current.right;

                while(replacement.left != null){
                    replacement = replacement.left;
                }
                current.data = replacement.data;
                current.right = deleteHelp(current.right,replacement.data);
//                current.data = replacement.data;
//                if(current.right != null) {
//                    current.right = current.right.right;
//                }
            }
        }

        else if(value < current.data ){
//                current = current.left;
            Node result = deleteHelp(current.left, value);
            current.left = result;
            System.out.println("Setting " +  current.data + "'s left to: " + result);
        }
        else{
//                current = current.right; Not needed
            current.right = deleteHelp(current.right,value);
        }
        //dont forget to count--


        if (getBalanceFactor(current) > 1){
            if(getBalanceFactor(current.left)>= 0){
                //right rotation
                current = rightRotation(current);
            }
            else{
                //left right rotation
                current = leftRotation(current);
                current = rightRotation(current);
            }
        }
        else if (getBalanceFactor(current) < -1){
            //right heavy
            if(getBalanceFactor(current.right)<=0){
                //left rotation
                current = leftRotation(current);
            }
            else{
                //right left rotation
                current = rightRotation(current);
                current = leftRotation(current);
            }
        }
        return current;

    }

    public int getNumOfChildren(Node node) {
        int childrenCount = 0;
        if(node.left != null){
            childrenCount++;
        }
        if(node.right != null) {
            childrenCount++;
        }
        return childrenCount;
    }

    public boolean search(int data) {
        // TODO: Call the recursive helper method (or implement iteratively)
        return false;
    }

    public int height(Node node) {
        // TODO: Implement this method
        // Hint: Use recursion - height = 1 + max(left height, right height)
        if(node == null) return 0;

        return 1+heightHelper(node,0,-1);
    }
    public int heightHelper(Node current , int mhght, int chght){
        chght++;
        if(chght>= mhght){
            mhght = chght;
        }
        if(current.left != null ){
            mhght = heightHelper(current.left, mhght, chght);
        }
        if (current.right != null) {
            mhght = heightHelper(current.right, mhght, chght);
        }
        return mhght;
    }

    public int getBalanceFactor(Node node){
        return height(node.left) - height(node.right);
    }


    public Node getRoot() {
        return root;
    }

    public int getSize() {
        // TODO: Call recursive helper method or implement iteratively
        return 0;
    }

    public boolean isEmpty() {
        // TODO: Check if root is null
        return false;
    }

    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        // TODO: Call recursive helper method with result list
        return result;
    }

    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        // TODO: Call recursive helper method with result list
        return result;
    }

    public List<Integer> postorderTraversal() {
        List<Integer> result = new ArrayList<>();
        // TODO: Call recursive helper method with result list
        return result;
    }

    public int getMin() {
        // TODO: Check if tree is empty, throw exception if so
        // TODO: Traverse to the leftmost node
        // TODO: Return the minimum value
        return 0;
    }

    public int getMax() {
        // TODO: Check if tree is empty, throw exception if so
        // TODO: Traverse to the rightmost node
        // TODO: Return the maximum value
        return 0;
    }
}
