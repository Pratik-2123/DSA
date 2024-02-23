package Hashing;
import java.util.*;

public class Union_intersection {
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : arr1) {
            set.add(i);
        }
        for (Integer i : arr2) {
            set.add(i);
        }

        System.out.println("Union = " + set.size());
        System.out.println(set);
        

        set.clear();

        for (Integer i : arr1) {
            set.add(i);
        }
        int count = 0;
        for(int i=0; i<arr2.length; i++) {
            if(set.contains(arr2[i])) {
                count++;
                System.out.print(arr2[i] + " ");
                set.remove(arr2[i]);
            }
        }
        System.out.println("Intersection is = " + count);
    }
}
