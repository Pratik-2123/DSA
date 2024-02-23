import java.util.ArrayList;

public class Stacks_using_AL {
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();
        //isEmpty
        public static boolean isempty() {
            return list.size() == 0;
        }

        //Push
        public static void Push(int data) {
            list.add(data);
        }

        //Pop
        public static int Pop() {
            if(isempty()) {
                return -1;
            }
            int top = list.size() - 1;
            list.remove(list.size()-1);
            return top;
        }

        //Peek
        public static int Peek() {
            if(isempty()) {
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String args[]) {
        Stack s = new Stack();
        s.Push(1);
        s.Push(2);
        s.Push(3);

        while(!s.isempty()) {
            System.out.println(s.Peek());
            s.Pop();
        }
    }
}
