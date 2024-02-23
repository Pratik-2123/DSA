import java.util.*;
public class MaxArea_in_Histogram {
    public static void MaxArea(int arr[]) {
        int maxArea = 0;
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        // Next smaller right
        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
               s.pop();
            } 

            if(s.isEmpty()) {
                nsr[i] = arr.length;   
            } else {
                nsr[i] = s.peek();
            }

            s.push(i);
        }

        // Next smaller left
        s = new Stack<>();   // This statement empties the current Stack 

        for(int i=0; i<arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        // current area = width = j-i-1 = nsr[i] - nsl[i] - 1
        for(int i=0; i<arr.length; i++) {
            int height = arr[i];
            int widht = nsr[i] - nsl[i] - 1;
            int currArea = height * widht;
            maxArea = Math.max(maxArea, currArea);
        }

        System.out.println("The maximum area in the given histogram is : " + maxArea);
    }
    public static void main(String args[]) {
        int arr[] = {2,1,5,6,2,3};
        MaxArea(arr);
    }
}
