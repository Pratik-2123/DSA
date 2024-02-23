import java.util.*;
public class traversal_tree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    } 
    static class B{
        static int idx = -1;
        public static Node buildtree(int Nodes[]) {
            idx++;
            if(Nodes[idx] == -1) {
            return null;
            }

            Node newNode = new Node(Nodes[idx]);
            newNode.left = buildtree(Nodes);
            newNode.right = buildtree(Nodes);
            return newNode;

        }
    }
    public static void preorder_traversal(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder_traversal(root.left);
        preorder_traversal(root.right);
    }

    public static void inOrder_traversal(Node root) {
        if(root == null) {
            return;
        }
        inOrder_traversal(root.left);
        System.out.print(root.data+" ");
        inOrder_traversal(root.right);

    }
    public static void postorder_traversal(Node root) {
        if(root == null) {
            return;
        }
        postorder_traversal(root.left);
        postorder_traversal(root.right);
        System.out.print(root.data+" ");
    }

    public static void levelOrder_traversal(Node root) {
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data+" ");
                if(currNode.left != null) {
                    q.add(currNode.left);
                } 
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }


    }
    public static void main(String args[]) {
        int Nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        B tree = new B();
        Node root = B.buildtree(Nodes);
        levelOrder_traversal(root);
        
    }
}