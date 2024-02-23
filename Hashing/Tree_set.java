package Hashing;
import java.util.*;
public class Tree_set {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Nagpur");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Raipur");

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Nagpur");
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        lhs.add("Raipur");

        TreeSet<String> ts = new TreeSet<>();
        ts.add("Nagpur");
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Noida");
        ts.add("Raipur");

        System.out.println(cities);
        System.out.println(lhs);
        System.out.println(ts);

    }
}
