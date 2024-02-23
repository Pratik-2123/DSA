package Hashing;
import java.util.*;
public class Hash_set {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);

        System.out.println(set);

        if(set.contains(2)) {
            System.out.println("Contains 2");
        } else {
            System.out.println("Not contains 2");
        }

        set.remove(2);
        System.out.println(set);
        System.out.println(set.size());
        set.clear();
        System.out.println(set.isEmpty());
    }
}
