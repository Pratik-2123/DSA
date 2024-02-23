package Queues;

import java.util.*;
public class Queue_using_JCF{
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>(); // ArrayDequeue
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}