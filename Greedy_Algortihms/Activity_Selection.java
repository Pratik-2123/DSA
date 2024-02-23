package Greedy_Algortihms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Activity_Selection {

    public static void act_sel_onedim(int start[], int end[]) {
        int maxAct = 0;

        //Adding 1st element
        ArrayList<Integer> list = new ArrayList<>();
        maxAct = 1;
        list.add(0);
        int lastEnd = end[0];
        for(int i=1; i<end.length; i++) {
            if(start[i] >= lastEnd) {
                list.add(i);
                maxAct++;
                lastEnd = end[i];
            }
        }

        System.out.print("The maximum activities are : " + maxAct);
        System.out.println();
        for(int i=0; i<list.size(); i++) {
            System.out.print("A"+list.get(i) + " ");
        }
    }

    public static void act_sel_twodim(int start[], int end[]) {
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i]; 
        }

        //lamda function 
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        int maxAct = 0;

        //Adding 1st element
        ArrayList<Integer> list = new ArrayList<>();
        maxAct = 1;
        list.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=1; i<end.length; i++) {
            if(activities[i][1] >= lastEnd) {
                list.add(activities[i][0]);
                maxAct++;
                lastEnd = activities[i][2];
            }
        }

        System.out.print("The maximum activities are : " + maxAct);
        System.out.println();
        for(int i=0; i<list.size(); i++) {
            System.out.print("A"+list.get(i) + " ");
        }
    }
    public static void main(String args[]) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};
        act_sel_onedim(start, end);
        act_sel_twodim(start, end);
    }    
}
