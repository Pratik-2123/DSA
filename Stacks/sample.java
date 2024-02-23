import java.util.*;
public class sample {
    public static int TrappingRainWater(int arr[]) {
        int mrb[] = new int[arr.length];
        int mlb[] = new int[arr.length]; 

        Stack<Integer> s = new Stack<>();

        //max Right Boundry
        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                mrb[i] = arr[i];
            } else {
                mrb[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0; i<arr.length; i++) {
            System.out.print(mrb[i] + " ");
        }
        System.out.println();

        s = new Stack<>();  // Stack empty

        //max Left Boundry
        for(int i=0; i<arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                mlb[i] = arr[i];
            } else {
                mlb[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0; i<arr.length; i++) {
            System.out.print(mlb[i] + " ");
        }

        //Trapped RainWater
        int trappedRainWater = 0;
        for(int i=0; i<arr.length; i++) {
            int waterLevel = Math.min(mlb[i], mrb[i]);
            //trapped water = waterlevel - arr[i]
            trappedRainWater += waterLevel - arr[i];
        }
        return trappedRainWater;
    }
    public static void main(String args[]) {
        int arr[] = {4,2,0,6,3,2,5};
        System.out.print("The total Rainwater trapped is : " + TrappingRainWater(arr));
    }
}
