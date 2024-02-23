package Queues;

public class implementation_usingARR {
    static class Queue {
        static int arr[];
        static int size;
        static int front,rear;

        Queue(int n) {
            size = n;
            arr = new int[n];
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;  //if rear is -1 then it returns true and if not returns false
        }

        public static void add(int data) {
            if(size == rear-1) {
                System.out.println("Queue is full");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        public static int remove() {
            if(rear == -1) {
                System.out.println("The queue is empty");
                return -1;
            }

            int front = arr[0];
            for(int i=0; i<rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        public static int peek() {
            if(rear == -1) {
                System.out.println("The queue is empty");
                return -1;
            }

            return arr[0];
        }
    }
    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
        

    }
}