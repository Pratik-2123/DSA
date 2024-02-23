public class Diameter_tree {
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

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh)+1;
    }


    public static int diameter2(Node root) {
        if(root == null) {
            return 0;
        }

        int leftdim = diameter2(root.left);
        int rightdim = diameter2(root.right);
        int leftht = height(root.left);
        int rightht = height(root.right);

        int selfht = leftht + rightht + 1;

        return Math.max(selfht, Math.max(rightht, leftht));
    }

    static class Info{
        int diam;
        int ht;
        public Info(int diam , int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root) {
        if(root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht+rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) +1;

        return new Info(diam, ht);
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameter(root).diam);
    }
}
