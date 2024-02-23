package Queues;
import java.util.*;

public class Deque_in_JCF {
    public static void main(String args[]) {
        Deque<Integer> q = new LinkedList<>();
        q.addFirst(1);
        q.addFirst(2);
        System.out.println(q);
        q.addLast(3);
        q.addLast(4);
        System.out.println(q);
        q.removeFirst();
        System.out.println(q);
        q.removeLast();
        System.out.println(q);
        System.out.println(q.getFirst());
        System.out.println(q.getLast());
    }
}
