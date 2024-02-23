package Queues;
import java.util.*;
public class Stack_Queue_using_Deque {
    static class Stack {
        Deque<Integer> q = new LinkedList<>();

        public void push(int data) {
            q.addLast(data);
        }    
        public int pop() {
            return q.removeLast();
        }
        public int peek() {
            return q.getLast();
        }
    } 
    static class Queue {
        Deque<Integer> q1 = new LinkedList<>();

        public void add(int data) {
            q1.addLast(data);
        }

        public int remove() {
            return q1.removeFirst();
        }

        public int peek() {
            return q1.getFirst();
        }
    } 
    public static void main(String args[]) {
        Stack s = new Stack();
        System.out.println("Stack");
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        
        System.out.println("Queue");

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
