import java.util.*;

class BST {

    private Node root;

    public BST() {
    }

    public boolean contains(Integer key) {
        return search_key(key) != null;
    }

    public void insert_key(Integer key) {
        root = insert_key(root, key);
    }

    private Node insert_key(Node n, Integer key) {
        if (n == null) {
            return new Node(key);
        } else if (key < n.getkey()) {
            n.setLeft(insert_key(n.getLeft(), key));
        } else if (key > n.getkey()) {
            n.setRight(insert_key(n.getRight(), key));
        }
        return n;
    }

    public void deleteTree() {
        root = null;
    }

    public void delete_key(Integer key) {
        root = delete_key(root, key);
    }

    private Node delete_key(Node n, Integer key) {
        if (n == null) {
            return null;
        } else if (key < n.getkey()) {
            n.setLeft(delete_key(n.getLeft(), key));
        } else if (key > n.getkey()) {
            n.setRight(delete_key(n.getRight(), key));
        } else {
            if (n.getRight() == null) {
                return n.getLeft();
            } else if (n.getLeft() == null) {
                return n.getRight();
            }
            Node m = n;
            n = min(m.getRight());
            n.setRight(delete_minimum(m.getRight()));
            n.setLeft(m.getLeft());
        }
        return n;
    }

    public Integer search_key(Integer key) {
        return search_key(root, key);
    }

    private Integer search_key(Node n, Integer key) {
        if (n == null) {
            return null;
        } else if (key < n.getkey()) {
            return search_key(n.getLeft(), key);
        } else if (key > n.getkey()) {
            return search_key(n.getRight(), key);
        } else {
            return n.getkey();
        }
    }

    private Node min(Node n) {
        if (n.getLeft() == null) {
            return n;
        } else {
            return min(n.getLeft());
        }
    }

    public int min_key() {
        Node x = root;
        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return x.getkey();
    }

    public int max_key() {
        Node x = root;
        while (x.getRight() != null) {
            x = x.getRight();
        }
        return x.getkey();
    }

    private Node delete_minimum(Node n) {
        if (n.getLeft() == null) {
            return n.getRight();
        }
        n.setLeft(delete_minimum(n.getLeft()));
        return n;
    }

    public Integer predecessor_key(Integer key) {
        Node n = predecessor_key(root, key);
        if (n == null) {
            return null;
        } else {
            return n.getkey();
        }
    }

    private Node predecessor_key(Node n, Integer key) {
        if (n == null) {
            return null;
        } else if (key <= n.getkey()) {
            return predecessor_key(n.getLeft(), key);
        } else {
            Node m = predecessor_key(n.getRight(), key);
            if (m != null) {
                return m;
            } else {
                return n;
            }
        }
    }

    public Integer successor_key(Integer key) {
        Node n = successor_key(root, key);
        if (n == null) {
            return null;
        } else {
            return n.getkey();
        }
    }

    private Node successor_key(Node n, Integer key) {
        if (n == null) {
            return null;
        } else if (key < n.getkey()) {
            Node m = successor_key(n.getLeft(), key);
            if (m != null) {
                return m;
            } else {
                return n;
            }
        } else {
            return successor_key(n.getRight(), key);
        }
    }

    public void printPreOrder() {
        System.out.print("Pre-order Traversal: ");
        printPreOrder(root);
        System.out.print("\n");
    }

    private void printPreOrder(Node n) {
        if (n != null) {
            n.print();
            printPreOrder(n.getLeft());
            printPreOrder(n.getRight());
        }
    }

    public void printInOrder() {
        System.out.print("In-order Traversal: ");
        printInOrder(root);
        System.out.print("\n");
    }

    private void printInOrder(Node n) {
        if (n != null) {
            printInOrder(n.getLeft());
            n.print();
            printInOrder(n.getRight());
        }
    }

    public void printPostOrder() {
        System.out.print("Post-order Traversal: ");
        printPostOrder(root);
        System.out.print("\n");
    }

    private void printPostOrder(Node n) {
        if (n != null) {
            printPostOrder(n.getLeft());
            printPostOrder(n.getRight());
            n.print();
        }
    }

    public int getDepth(Integer key) {
        return getNodeDepth(root, key, 0);
    }

    public int getNodeDepth(Node n, Integer x, int height) {
        if (n == null)
            return 0;
        if (n.getkey() == x)
            return height;

        int level = getNodeDepth(n.getLeft(), x, height + 1);

        if (level != 0)
            return level;

        return getNodeDepth(n.getRight(), x, height + 1);
    }

    public boolean isEmpty() {
        return root == null;
    }
}

class Node {
    private Node left, right;
    private Integer key;

    public Node(Integer key) {
        this.key = key;
        left = null;
        right = null;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

    public void setKey(Integer k) {
        this.key = k;
    }

    public Integer getkey() {
        return key;
    }

    public void print() {
        if (key != null) {
            System.out.print(key + " ");
        }
    }
}

public class BinarySearchTree {

    public void display_options() {
        System.out.println("\nBinary Search Tree Options\n");
        System.out.println("1. Insert key into tree");
        System.out.println("2. Delete key in the tree");
        System.out.println("3. Search in the tree");
        System.out.println("4. Minimum Key in the tree");
        System.out.println("5. Maximum Key in the tree");
        System.out.println("6. Successor for Key in the tree");
        System.out.println("7. Predecessor for Key in the tree");
        System.out.println("8. Preorder, Inorder and Postorder  ");
        System.out.println("9. Delete all nodes in the tree");
        System.out.println("0. Quit");
        System.out.println("Enter your Choice :");
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        Scanner st = new Scanner(System.in);
        BST bst = new BST();
        int ky;
        boolean run_prog = true;
        do {
            tree.display_options();
            int choice = st.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Enter element to insert ");
                ky = st.nextInt();
                bst.insert_key(ky);
                System.out.println("Depth of " + ky + " is " + bst.getDepth(ky));
                break;
            case 2:
                System.out.println("Enter element to delete ");
                ky = st.nextInt();
                if (bst.contains(ky)) {
                    System.out.println("Depth of " + ky + " is " + bst.getDepth(ky));
                    bst.delete_key(ky);
                    System.out.println(ky + " is deleted.");
                } else {
                    System.out.println("Deletion unsuccessful.");
                }
                break;
            case 3:
                System.out.println("Enter element to search ");
                ky = st.nextInt();
                if (bst.contains(ky)) {
                    System.out.println("Key found");
                    System.out.println("Depth of " + ky + " is " + bst.getDepth(ky));
                } else {
                    System.out.println("Key not found");
                }

                break;
            case 4:
                if (bst.isEmpty()) {
                    System.out.println("Tree is empty.");
                } else {
                    int min = bst.min_key();
                    System.out.println("Minimum = " + min);
                    System.out.println("Depth of " + min + " is " + bst.getDepth(min));
                }
                break;
            case 5:
                if (bst.isEmpty()) {
                    System.out.println("Tree is empty.");
                } else {
                    int max = bst.max_key();
                    System.out.println("Maximum = " + max);
                    System.out.println("Depth of " + max + " is " + bst.getDepth(max));
                }
                break;
            case 6:
                System.out.println("Enter element to find its successor");
                ky = st.nextInt();
                try {
                    int suc_element = bst.successor_key(ky);

                    System.out.println("Successor = " + suc_element);
                    System.out.println("Depth of " + suc_element + " is " + bst.getDepth(suc_element));
                    break;
                } catch (Exception e) {
                    System.out.println("Successor Doesn't Exist.");
                    break;
                }
            case 7:
                System.out.println("Enter key element to find its predecessor:");
                ky = st.nextInt();
                try {
                    int pre_element = bst.predecessor_key(ky);
                    System.out.println("Predecessor = " + pre_element);
                    System.out.println("Depth of " + pre_element + " is " + bst.getDepth(pre_element));
                    break;
                } catch (Exception e) {
                    System.out.println("Predecessor Doesn't Exist.");
                    break;
                }
            case 8:
                bst.printPreOrder();
                bst.printInOrder();
                bst.printPostOrder();
                break;
            case 9:
                bst.deleteTree();
                System.out.println("Tree is deleted.");
                bst.printPreOrder();
                bst.printInOrder();
                bst.printPostOrder();
                break;
            case 0:
                run_prog = false;
                break;
            default:
                System.out.println("Illegal Entry. Please enter valid choice \n ");
                break;
            }
        } while (run_prog);
        st.close();
    }
}
