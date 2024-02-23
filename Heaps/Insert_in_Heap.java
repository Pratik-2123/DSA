package Heaps;
import java.util.*;

public class Insert_in_Heap {
   

    static class Heap {     //O(logn)
        static ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);

            int x = arr.size()-1;
            int par = (x-1)/2;

            while(arr.get(x) < arr.get(par)) {    // O(logn)
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        private void Heapify(int i) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if(minIdx != i) {
                //Swap as the values of minIdx and i is changed
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                Heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // 1st Step -> Swap 1st and last Node
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // 2nd Step -> Remove Last Node
            arr.remove(arr.size()-1);

            // 3rd Step -> Fix the heap
            Heapify(0);

            return data;
        }

        public static int peek() {
            return arr.get(0);
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String args[]) {
        Heap h = new Heap();

        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        while (!h.isEmpty()) {
            System.out.print(h.peek() + " ");
            h.remove();
        }
    }
}
