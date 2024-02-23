package bst_part1;
public class binary {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(val > root.data) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }

        return root;
    }
    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if(key < root.data) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
    public static Node findInorderSuccesor(Node root) {
        while(root.left != null) {
            root = root.left;
        }

        return root;
    }
 
    public static Node delete(Node root, int val) {
        if(root.data > val) {
            root.left = delete(root.left, val);
        } else if(root.data < val) {
            root.right = delete(root.right, val);
        } else {
            //Case 1 - Leaf Node / No child
            if(root.left == null && root.right == null) {
                return null;
            }

            //Case 2 - Single child
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            //Case 3 - Both the children
            Node IS = findInorderSuccesor(root.right);
            root.data = IS.data;
            root.right = delete(root.right,IS.data);
        }
        return root;
    }

    public static void printInRange(Node root,int k1, int k2) {
        if(root == null) {
            return;
        }

        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        } else if(root.data < k1) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }
    public static void main(String args[]) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);

        System.out.println();
        printInRange(root, 5, 12);
        
    }
}
