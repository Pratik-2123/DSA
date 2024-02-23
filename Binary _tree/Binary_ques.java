public class Binary_ques {
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
    
        public static boolean checkUnivalued(Node root,int n) {
            if(root == null) {
                return true;
            }
                
            if(root.left != null && root.data != root.left.data) {
                return false;
            } 
            if(root.right != null && root.data != root.right.data) {
                return false;
            }
    
            return checkUnivalued(root.left, n) && checkUnivalued(root.right, n);
        }
    
        public static void interchange(Node root) {
            if(root == null) {
                return;
            }
    
            interchange(root.left);
            interchange(root.right);
    
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        public static void preOrder(Node root) {
            if(root == null) {
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    
        public static void deleteleaf(Node root, int key) {
            if(root == null) {
                return;
            }
            deleteleaf(root.left, key);
            deleteleaf(root.right, key);
    
            if(root.data == key && root.left == null && root.right == null) {
                root.data = 0;
            }
        }
        public static void main(String args[]) { 
            Node root = new Node(1);
            root.left = new Node(3);
            root.right = new Node(3);
            root.left.left = new Node(3);
            root.left.right = new Node(2);
            // root.right.left = new Node(6);
            // root.right.right = new Node(7);
    
            preOrder(root);
            System.out.println();
            deleteleaf(root, 3);
            preOrder(root);
            
        }
}