import java.util.*;
public class BST_ques {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int finaldiff = Integer.MAX_VALUE;
    public static int ClosestBST(Node root, int key) {
        if(root == null) {
            return 0;
        }
        int diff;
        if(root.data > key) {
            diff = root.data - key;
        } else if(root.data < key) {
            diff = key - root.data;
        } else {
            diff = 0;
        }

        if(diff < finaldiff) {
            finaldiff = diff;
        }

        int leftdiff = ClosestBST(root.left, key);
        int rightdiff = ClosestBST(root.right, key);

        return finaldiff;
    }

    public static void getInorder(Node root,ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }
    public static int kthsmallest(Node root,int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        getInorder(root, arr);
        
        return arr.get(k);
    }
    public static void main(String args[]) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);

        root.right = new Node(11);
        root.right.right = new Node(20);
        System.out.println(kthsmallest(root, 0));
    }
}
