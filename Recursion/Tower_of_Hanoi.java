package Recursion;
public class Tower_of_Hanoi {
    public static void TowerOfHanoi(int n , char src, char dest , char help) {
        if(n == 1) {
            System.out.println("Move disk " + n + " From " + src + " to " + dest);
            return;
        }

        TowerOfHanoi(n-1, src, help, dest);
        System.out.println("Move disk " + n + " From " + src + " to " + dest);
        TowerOfHanoi(n-1, help, dest, src);
    }
    public static void main(String args[]) {
        int n = 3;
        TowerOfHanoi(n, 'A', 'C', 'B');
    }
}
