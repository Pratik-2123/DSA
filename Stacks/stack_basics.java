import java.util.*;
public class stack_basics {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int i=0;
        while(i<str.length()) {
            s.push(str.charAt(i));
            i++;
        }

        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }

        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void StockSpan(int Stock[], int Span[]) {
        Stack<Integer> s = new Stack<>();
        Span[0] = 1;
        s.push(0);

        for(int i=1; i<Stock.length; i++) {
            int currPrice = Stock[i];
            while(!s.isEmpty() && currPrice > Stock[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                Span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                Span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
    public static void main(String args[]) {
        // String result = reverseString("abc");
        // System.out.println(result);

        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // reverseStack(s);
        // printStack(s);

        // int Stock[] = {100,80,60,70,60,85,100};
        // int Span[] = new int[Stock.length];
        // StockSpan(Stock, Span);
        // for(int i=0; i<Span.length; i++) {
        //     System.out.print(Span[i] + " ");
        // }

    }
}
