package Recursion;

public class Print_inc_dec_fact {
    // Program of recusion to print the number in decreasing order
    public static void Printdec(int n) {
        if(n == 1) {
            System.out.println(n);
            return;
        }
        System.out.print(n + " ");
        Printdec(n-1);
    }

    // Program of recursion to print the number in the increasing order
    public static void PrintInc(int n) {
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }
        PrintInc(n-1);
        System.out.print(n + " ");
    }
    
    // Program of recursion to find the factorial of any number 
    public static int Fact(int n ) {
        if(n == 0) {
            return 1;
        }
        int fnm1 = Fact(n-1);
        int fn = n * fnm1;
        return fn;
    }

    public static void main(String args[]) {
        int n = 5;
        System.out.println("Numbers in the decreasing order are :");
        Printdec(n);
        
        System.out.println("Numbers in increasing order are :");
        PrintInc(n);
        System.out.println();
        
        System.out.println("The factorial of the number is :" + Fact(n));
    }
}
