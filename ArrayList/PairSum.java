import java.util.*;
public class PairSum{
    // Brute Force
    public static boolean PairSum1(ArrayList<Integer> list, int target) {

        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size(); j++) {
                if(list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 2 Pointer Approach
    public static boolean PairSum_2ptr(ArrayList<Integer> list, int target) {
        int lp = 0, rp = list.size()-1;
        while(lp<rp) {
            //Case 1
            if(list.get(lp)+list.get(rp) == target) {
                return true;
            }

            //Case 2
            if(list.get(lp)+list.get(rp) < target){
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    //Pair Sum 2 Which is Sorted and rotated
    public static boolean PairSum2(ArrayList<Integer> list, int target) {
        int pivot = -1;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) > list.get(i+1)) {
                pivot = i;
                break;
            }
        }
        int lp = pivot+1;
        int rp = pivot;
        
        while(lp != rp) {
            //Case 1
            if(list.get(lp)+list.get(rp) == target) {
                return true;
            }

            //Case 2
            if(list.get(lp) + list.get(rp) < target) {
                lp = (lp+1) % list.size() ;
            } else {
                rp = (list.size()+rp-1)%list.size();
            }
        }
        return false;
    } 
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        
        System.out.println(PairSum2(list, target));
    }
}