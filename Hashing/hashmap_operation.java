package Hashing;
import java.util.*;
public class hashmap_operation {
    public static void main(String args[]) {
        // create
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Pakistan", 5);
        System.out.println(hm);

        // get
        System.out.println(hm.get("India"));

        //Cointains Key
        System.out.println(hm.containsKey("China"));
        System.out.println(hm.containsKey("Indonesia"));

        //Remove
        hm.remove("Pakistan");
        System.out.println(hm);

        //size
        System.out.println(hm.size());

        //isEmpty
        System.err.println(hm.isEmpty());

        hm.clear();
        System.out.println(hm.isEmpty());
    }
}
