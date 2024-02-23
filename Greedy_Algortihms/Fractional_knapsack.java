package Greedy_Algortihms;

import java.util.Arrays;
import java.util.Comparator;

public class Fractional_knapsack {
    public static void main(String args[]) {
        int val[] = {60,100,120};
        int weight[] = {10,20,30};
        int W = 50;

        double ratio[][] = new double[weight.length][2];
        for(int i=0; i<weight.length;i++) {
            ratio[i][0] = i;
            ratio[i][1] = (val[i] / (double)weight[i]);
        }

        //Ascending order sorting
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));

        int capacity = W;
        int finalVal = 0;
        for(int i=ratio.length-1; i>=0; i--) {
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]) { //Include full
                finalVal += val[idx];
                capacity -= weight[idx];
            } else { // When humko kuch fraction me cheezo ko lene hota hy in that case
                finalVal += ratio[i][1]*capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println("The final value coming will be "+ finalVal);
    }
}
