package Queues;
import java.util.*;
public class First_non_repeatin_ch {
    public static void firstNonRepeatingch(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;  //ch-'a' yeh krne se index milta hy which is in int

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }

            if(q.isEmpty()) {
                System.out.print(-1 +" ");
            } else {
                System.out.print(q.peek()+" ");
            }
        }
    }
    public static void main(String args[]) {
        String str = "aabccxb";
        firstNonRepeatingch(str);
    }
}
