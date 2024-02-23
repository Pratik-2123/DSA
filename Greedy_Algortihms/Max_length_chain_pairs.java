package Greedy_Algortihms;

import java.util.Arrays;
import java.util.Comparator;

public class Max_length_chain_pairs {
    public static void main(String[] args) {
        int a[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(a,Comparator.comparingDouble(o->o[1]));

        int ans = 1;  // 1st element ko already add kar liya hy isiliye 1 se initialize kiya hy
        int chainend = a[0][1];

        for(int i=1; i<a.length; i++) {
            if(a[i][0] > chainend) {
                ans++;
                chainend = a[i][1];
            }
        }

        System.out.print("Maximum Lenght of chain : " + ans);
    }
}
