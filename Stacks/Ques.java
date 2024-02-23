import java.util.*;
public class Ques {
    public class Node{
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = next;
        }
    } 
    // Checking if the Singly linked list is Palindrome or not using stack
    public static boolean isPalindrome(Node head) {    // TC & SC = O(n)
        boolean isPalindrome = true;
        Stack<Integer> s = new Stack<>();
        Node slow = head;

        while(slow != null) {
            s.push(slow.data);
            slow = slow.next;
        }

        while(head != null) {
            int i = s.pop();
            if(i == head.data) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
            head = head.next;
        }
        return isPalindrome;
    }
    public static void main(String args[]) {
        Ques ll = new Ques();
        Node one = ll.new Node(1);
        Node head = one;
        Node two = ll.new Node(2);
        Node three = ll.new Node(3);
        Node four = ll.new Node(2);
        Node five = ll.new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;

        System.out.println(ll.isPalindrome(head));
    }
}