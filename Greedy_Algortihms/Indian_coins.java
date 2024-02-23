package Greedy_Algortihms;

import java.util.*;

public class Indian_coins {
    public static void main(String args[]) {
        Integer coins[] = {1,2,5,10,20,50,100,500,2000};

        Arrays.sort(coins, Comparator.reverseOrder());

        int coinsCount = 0;
        int amt = 590;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<coins.length; i++){
            if(coins[i] <= amt){
                while(coins[i] <= amt) {
                    amt -= coins[i];
                    coinsCount++;
                    list.add(coins[i]);
                }
            }
        }

        System.out.println("The Coins used are : "+ coinsCount);

        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
