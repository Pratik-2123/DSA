package Hashing;
import java.util.*;
public class Count_distinct_elements {
    public static void main(String[] args) {
        int num[] = {4,3,2,5,6,7,3,4,2,1};

        HashSet<Integer> set = new HashSet<>();
        for (Integer idx : num) {
            set.add(idx);
        }

        System.out.println(set.size());
    }
}
