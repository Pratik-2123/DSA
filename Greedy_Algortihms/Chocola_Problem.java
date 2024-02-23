package Greedy_Algortihms;
import java.util.*;
public class Chocola_Problem {
    //Hard Level Question
    public static void main(String args[]) {
        Integer costVer[] = {2,1,3,1,4};
        Integer costHor[] = {4,1,2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0, v=0;
        int hp=1, vp=1;
        int cost = 0;

        while(h < costHor.length && v < costVer.length) {
            if(costVer[v] < costHor[h]) { //Horizontal Cut
                cost += (vp * costHor[h]);
                hp++;
                h++;
            } else { //Vertical Cut
                cost += (hp * costVer[v]);
                vp++;
                v++;
            }
        }
        while(h < costHor.length) {
            cost += (vp * costHor[h]);
            hp++;
            h++;
        }
        while(v < costVer.length) {
            cost += (hp * costVer[v]);
            vp++;
            v++;
        }
        
        System.out.println("The minimum cost is : " + cost);
    }
}
