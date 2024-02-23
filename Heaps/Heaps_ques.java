package Heaps;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Heaps_ques {
    static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void fill_N_slots(int n,int k,int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++) {
            pq.add(arr[i]);
        }

        System.out.print(pq.remove());
    }

    

    public static void main(String args[]) {
        // int n=5, k=5;
        // int arr[] = {2,1,3,4,5};
        // fill_N_slots(n, k, arr);
    }
}
