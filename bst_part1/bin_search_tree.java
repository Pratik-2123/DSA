package bst_part1;
import java.util.*;
public class bin_search_tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
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
    public static void printPath(ArrayList<Integer> path) {
        for(int i=0; i<path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }

    public static void printRoot2leaf(Node root, ArrayList<Integer> path) {
       if(root == null) {
            return;
       } 
       path.add(root.data);
       if(root.left == null && root.right == null) {
            printPath(path);
       }
       printRoot2leaf(root.left, path);
       printRoot2leaf(root.right, path);
       path.remove(path.size()-1);
    }

    public static boolean isValid(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.data <= min.data) {
            return false;
        } else if(max != null && root.data >= max.data) {
            return false;
        }

        return isValid(root.left, min, root) && isValid(root.right, root, max);

    }

    public static Node createMirror(Node root) {
        if(root == null) {
            return null;
        }

        Node leftmirror = createMirror(root.left);
        Node rightmirror = createMirror(root.right);

        root.left = rightmirror;
        root.right = leftmirror;

        return root;
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node CreateBST(int arr[],int st,int end) {
        if(st > end) {
            return null;
        }

        int mid = (st+end)/2;
        Node newroot = new Node(arr[mid]);
        newroot.left = CreateBST(arr, st, mid-1);
        newroot.right = CreateBST(arr, mid+1, end);

        return newroot;
    }
    public static void main(String args[]) {
        int arr[] = {3,5,6,8,10,11,12};

        Node root = CreateBST(arr, 0, arr.length);
        preOrder(root);
    }
}
