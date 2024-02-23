package ArrayList;
import java.util.*;

public class Cointainer_wd_mostWater {
    public static int MostWater_2ptr(ArrayList<Integer> height) {
        int MaxWater=0; 
        int lp = 0, rp = height.size()-1;

        while(lp<rp) {
            //area
            int ht = Math.min(height.get(lp),height.get(rp));
            int width = rp - lp;
            int area = ht * width;
            MaxWater = Math.max(MaxWater, area); 
            //update 
            if(height.get(lp) < height.get(rp)) {
                lp++;
            } else {
                rp--;
            }
        }
        return MaxWater;
    }

    public static int MaxWater(ArrayList<Integer> height) {
        int maxwater = 0;
        //Brute Force
        for(int i=0; i<height.size(); i++) {
            for(int j=i+1; j<height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j-i;
                int watercointained = ht * width;
                maxwater = Math.max(maxwater, watercointained);
            }
        }
        return maxwater;
    }
    public static void main(String args[]) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        // System.out.println(MaxWater(height));
        System.out.println(MostWater_2ptr(height));
    }
}
