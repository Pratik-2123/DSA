package Hashing;
import java.util.*;
import java.util.TreeMap;

public class hash_ques {
    public static void sum(int arr[], int k) {
        HashMap<Integer,Integer> visited = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            int diff = k - arr[i];

            if(visited.containsKey(diff)) {
                System.out.print("[" + i + ", " + visited.get(i) + "]");
            }

            visited.put(arr[i], i);
        }
    }

    public static void Sort_by_freq(String str) {
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(int i=0; i<str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }

        System.out.println(map);
    }
    public static void main(String[] args) {
        int arr[] = {3,2,4};
        int k = 6;
        // int i=0;
        // for(int j=i+1; j<arr.length; j++) {
        //     if(arr[i] + arr[j] == k) {
        //         System.out.print("[" + i + ", " + j + "]");
        //         break;
        //     } else {
        //         i++;
        //     }
        // }
        String str = "cccaaa";
        sum(arr, k);
        System.out.println();
        Sort_by_freq(str);
    }
}
