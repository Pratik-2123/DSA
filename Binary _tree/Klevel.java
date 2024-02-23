public class Klevel {
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

    public static void klevel(Node root, int level , int key) {
        if(root == null) {
            return;
        }
        if(level == key) {
            System.out.print(root.data+" ");
            return;
        }

        klevel(root.left, level+1, key);
        klevel(root.right, level+1, key);
    }
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int key = 3;
        klevel(root, 1, key);
    }
}
