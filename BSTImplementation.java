/*
    Java Program to perform Binary Search Tree Operations.
    CS-721 Advanced Algorithms & Analysis
    Programming Assignment
    by Chakradhar Reddy Donuri (E949F496)
*/

import java.io.*;
import java.util.*;

class BSTNode {
    private BSTNode left,right;
    private Integer data;

    public BSTNode(Integer data)
    {
        this.data = data;
        left = null;
        right = null;
    }
    public void setLeft(BSTNode left){
        this.left = left;
    }
    public void setRight(BSTNode right){
        this.right = right;
    }
    public BSTNode getLeft(){
        return left;
    }
    public BSTNode getRight(){
        return right;
    }
    public void setKey(Integer k) {
        this.data = k;
    }
    public Integer getData() {
        return data;
    }
    public void print() {
        if (data != null) {
            System.out.print(data+" ");
        }
    }
}

class BinarySearchTree {

    private BSTNode root;
    public BinarySearchTree() {
    }

    // Function to check a node is present or not
    public boolean contains(Integer data) {
        return search_element(data) != null;
    }

    // Function to Search a node
    public Integer search_element(Integer data) {
        return search_element(root, data);
    }
    private Integer search_element(BSTNode n, Integer data) {
        if (n == null) {
            return null;
        } else if (data < n.getData()) {
            return search_element(n.getLeft(), data);
        } else if (data > n.getData()) {
            return search_element(n.getRight(), data);
        } else {
            return n.getData();
        }
    }

    // Function to Insert a new node
    public void insert_element(Integer data) {
        root = insert_element(root, data);
    }
    private BSTNode insert_element(BSTNode n, Integer data) {
        if (n == null) {
            return new BSTNode(data);
        } else if (data < n.getData()) {
            n.setLeft(insert_element(n.getLeft(), data));
        } else if (data > n.getData()) {
            n.setRight(insert_element(n.getRight(), data));
        }
        return n;
    }

    //Function to delete the whole tree
    public void deleteTree()
    {
        root = null;
    }

    //Function to Delete a node
    public void delete_element(Integer data) {
        root = delete_element(root, data);
    }

    private BSTNode delete_element(BSTNode n, Integer data) {
        if (n == null) {
            return null;
        } else if (data < n.getData()) {
            n.setLeft(delete_element(n.getLeft(), data));
        } else if (data > n.getData()) {
            n.setRight(delete_element(n.getRight(), data));
        } else {
            if (n.getRight() == null) {
                return n.getLeft();
            } else if (n.getLeft() == null) {
                return n.getRight();
            }
            BSTNode m = n;
            n = min(m.getRight());
            n.setRight(deleteMin(m.getRight()));
            n.setLeft(m.getLeft());
        }
        return n;
    }

    // Function to min node
    private BSTNode min(BSTNode n) {
        if (n.getLeft() == null) {
            return n;
        } else {
            return min(n.getLeft());
        }
    }

    public int minimum() {
        BSTNode x = root;
        while(x.getLeft() != null)
        {
            x = x.getLeft();
        }
        return x.getData();
    }

    public int maximum() {
        BSTNode x = root;
        while(x.getRight() != null)
        {
            x = x.getRight();
        }
        return x.getData();
    }

    //  Function to deleteMin
    private BSTNode deleteMin(BSTNode n) {
        if (n.getLeft() == null) {
            return n.getRight();
        }
        n.setLeft(deleteMin(n.getLeft()));
        return n;
    }

    // Function to find predecessor element
    public Integer predecessor(Integer data) {
        BSTNode n = predecessor(root, data);
        if (n == null) {
            return null;
        } else {
            return n.getData();
        }
    }

    private BSTNode predecessor(BSTNode n, Integer data) {
        if (n == null) {
            return null;
        } else if (data <= n.getData()) {
            return predecessor(n.getLeft(), data);
        } else {
            BSTNode m = predecessor(n.getRight(), data);
            if (m != null) {
                return m;
            } else {
                return n;
            }
        }
    }

    // Function to find successor of a data
    public Integer successor(Integer data) {
        BSTNode n = successor(root, data);
        if (n == null) {
            return null;
        } else {
            return n.getData();
        }
    }


    private BSTNode successor(BSTNode n, Integer data) {
        if (n == null) {
            return null;
        } else if (data < n.getData()) {
            BSTNode m = successor(n.getLeft(), data);
            if (m != null) {
                return m;
            } else {
                return n;
            }
        } else {
            return successor(n.getRight(), data);
        }
    }

    // Function to Print PreOrder Traversal
    public void printPreOrder() {
        System.out.print("Pre-order: ");
        printPreOrder(root);
        System.out.print("\n");
    }

    // Function to find PreOrder Traversal
    private void printPreOrder(BSTNode n) {
        if (n != null) {
            n.print();
            printPreOrder(n.getLeft());
            printPreOrder(n.getRight());
        }
    }

    // Function to Print InOrder Traversal
    public void printInOrder() {
        System.out.print("In-order: ");
        printInOrder(root);
        System.out.print("\n");
    }

    //  Function to find InOrder Traversal
    private void printInOrder(BSTNode n) {
        if (n != null) {
            printInOrder(n.getLeft());
            n.print();
            printInOrder(n.getRight());
        }
    }

    // Function to Print PostOrder Traversal
    public void printPostOrder() {
        System.out.print("Post-order: ");
        printPostOrder(root);
        System.out.print("\n");
    }

    //  Function to find PostOrder Traversal
    private void printPostOrder(BSTNode n) {
        if (n != null) {
            printPostOrder(n.getLeft());
            printPostOrder(n.getRight());
            n.print();
        }
    }

    // Function to find Depth
    public int getDepth(Integer data) {
        return getNodeDepth(root, data,0);
    }

    public int getNodeDepth(BSTNode n, Integer x, int height){
        if(n==null) return 0;
        if(n.getData()==x) return height;

        int level = getNodeDepth(n.getLeft(),x,height+1);

        if(level!=0) return level;

        return getNodeDepth(n.getRight(),x,height+1);
    }

    //Function to check if tree is empty
    public boolean isEmpty()
    {
        return root == null;
    }
}


public class BSTImplementation {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("\tBinary Search Tree Operations Implementation \n");
        int element;
        boolean loop =true;
        do{
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("\nBinary Search Tree Options\n");
            System.out.println("1. Insert ");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Minimum Key");
            System.out.println("5. Maximum Key");
            System.out.println("6. Successor for Key");
            System.out.println("7. Predecessor for Key");
            System.out.println("8. Preorder, Inorder and Postorder traversal ");
            System.out.println("9. Delete All Nodes");
            System.out.println("0. Quit");
            System.out.println("Enter your option :");

            int option = sc.nextInt();
            switch (option)
            {
                case 1 :
                    System.out.println("Enter key element to be inserted: ");
                    element = sc.nextInt();
                    bst.insert_element( element );
                    System.out.println("Depth of "+ element + " is "+ bst.getDepth(element));
                    break;
                case 2 :
                    System.out.println("Enter key element to be deleted: ");
                    element = sc.nextInt();
                    if(bst.contains(element)) {
                        System.out.println("Depth of "+ element + " is "+ bst.getDepth(element));
                        bst.delete_element( element);
                        System.out.println(element + " is deleted.");
                    }
                    else {
                        System.out.println("Deletion unsuccessful." );
                    }
                    break;
                case 3 :
                    System.out.println("Enter key element to be searched: ");
                    element = sc.nextInt();
                    if(bst.contains(element)) {
                        System.out.println("Key found.");
                        System.out.println("Depth of "+ element + " is "+ bst.getDepth(element));
                    }
                    else {
                        System.out.println("Key not found." );
                    }

                    break;
                case 4 :
                    if (bst.isEmpty()) {
                        System.out.println("Tree is empty.");
                    }
                    else {
                        int min = bst.minimum();
                        System.out.println("Minimum Key = "+ min );
                        System.out.println("Depth of "+ min + " is "+ bst.getDepth(min));
                    }
                    break;
                case 5 :
                    if (bst.isEmpty()) {
                        System.out.println("Tree is empty.");
                    }
                    else {
                        int max = bst.maximum();
                        System.out.println("Maximum Key = "+ max );
                        System.out.println("Depth of "+ max + " is "+ bst.getDepth(max));
                    }
                    break;
                case 6 :
                    System.out.println("Enter key element to find its successor:");
                    element = sc.nextInt();
                    try {
                        int suc_element = bst.successor(element);

                        System.out.println("Successor Key = "+ suc_element);
                        System.out.println("Depth of "+ suc_element + " is "+ bst.getDepth(suc_element));
                        break;
                    }
                    catch(Exception e) {
                        System.out.println("Successor Key Doesn't Exist.");
                        break;
                    }
                case 7 :
                    System.out.println("Enter key element to find its predecessor:");
                    element = sc.nextInt();
                    try {
                        int pre_element = bst.predecessor(element);
                        System.out.println("Predecessor Key = "+ pre_element);
                        System.out.println("Depth of "+ pre_element + " is "+ bst.getDepth(pre_element));
                        break;
                    }
                    catch(Exception e) {
                        System.out.println("Predecessor Key Doesn't Exist.");
                        break;
                    }
                case 8 :
                    bst.printPreOrder();
                    bst.printInOrder();
                    bst.printPostOrder();
                    break;
                case 9 :
                    bst.deleteTree();
                    System.out.println("All Nodes of the tree are deleted.");
                    bst.printPreOrder();
                    bst.printInOrder();
                    bst.printPostOrder();
                    break;
                case 0 :
                    loop = false;
                    break;
                default :
                    System.out.println("Wrong Entry. \n ");
                    break;
            }
        }while(loop);
        sc.close();
        System.out.println("------The End------");
    }
}

