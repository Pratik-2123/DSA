package Greedy_Algortihms;

import java.util.Arrays;

public class Min_abs_diff {
    public static void main(String[] args) {
        int a[] = {1,2,3};
        int b[] = {2,1,3};

        Arrays.sort(a);
        Arrays.sort(b);

        int mindiff = 0;
        for(int i=0; i<a.length; i++) {
            mindiff += Math.abs(a[i]-b[i]);
        }

        System.out.print("The minimum diffrence is " + mindiff);
    }
}
