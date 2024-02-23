import java.util.*;

public class NextGreater {
    public static void nxtGreaterElement(int arr[]) {

        int nxtGreater[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {    // Reverse Tracking 
            
            //1 Step
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            //2 Step
            if(s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }

            //3 Step 
            s.push(i);
        }
        
        for(int i=0; i<nxtGreater.length; i++) {
            System.out.print(nxtGreater[i] + " ");
        }
    
    }
    public static void main(String args[]) {
        int arr[] = {6,8,0,1,3};
        nxtGreaterElement(arr);
    }
}