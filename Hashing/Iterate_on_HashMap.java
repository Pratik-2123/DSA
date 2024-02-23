package Hashing;

import java.util.*;
public class Iterate_on_HashMap {
    public static void main(String args[]) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Nepal", 5);
        hm.put("US", 50);

        System.out.println(hm);

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key = " + k + " , value = " + hm.get(k));
        }
    }   
}
