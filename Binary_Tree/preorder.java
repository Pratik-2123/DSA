package Binary_Tree;
public class preorder {
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
    public static void main(String args[]) {
        int Nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        B tree = new B();
        Node root = B.buildtree(Nodes);
        System.out.print(root.data);
    }
}
