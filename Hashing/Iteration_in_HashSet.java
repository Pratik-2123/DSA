package Hashing;
import java.util.*;
public class Iteration_in_HashSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Nagpur");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        cities.add("Raipur");

        System.out.println("Iteration using Iterator");
        Iterator it = cities.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("Iteration using For-Each loop");
        for (String city : cities) {
            System.out.println(city);
        }
    }
}
