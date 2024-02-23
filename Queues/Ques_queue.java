package Queues;
import java.util.*;
public class Ques_queue {
    //Question 4
    public static void reverse_K_elements(Queue<Integer> q, int key) {
        Queue<Integer> q1 = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<key; i++) {
            s.push(q.remove());
        }

        while(!s.isEmpty()) {
            q1.add(s.pop());
        }
        while(!q.isEmpty()) {
            q1.add(q.remove());
        }

        System.out.println(q1);

    }
    public static void maxSubarrays(int arr[], int k) {
        int newArr[] = new int[arr.length];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<k; j++) {
                if(q.isEmpty()) {
                    q.add(arr[i]);
                } else if(q.peek() < arr[i]) {
                    q.add(arr[j]);
                }
            }
            newArr[i] = q.peek();
        }

        for(int i=0; i<arr.length;i++) {
            System.out.print(newArr[i] + " ");
        }
    }
    public static void main(String args[]) { 
        // Queue<Integer> q = new LinkedList<>();
        // q.add(10);
        // q.add(20);
        // q.add(30);
        // q.add(40);
        // q.add(50);
        // q.add(60);     //Question 4
        // q.add(70);
        // q.add(80);
        // q.add(90);
        // q.add(100); 
        // System.out.println(q);
        // reverse_K_elements(q, 5);


        int arr[] = {1,2,3,1,4,5,2,3,6};
        maxSubarrays(arr, 3);
    }   
}