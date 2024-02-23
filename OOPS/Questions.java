package OOPS;

import java.util.Scanner;

// Question 1 of Pratice Sheet

public class Questions {
     public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Print the imaginary no in the form of a + bi");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Print the another imaginary no. in the form of c + di");
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println("Now two imaginary complex no. are " + a + "+" + b + "i" + " and "+ c + "+" + d + "i");

        Calculate c1 = new Calculate();
        c1.Sum(a, b, c, d);
        c1.multiply(a, b, c, d);
        c1.division(a, b, c, d);
        
    }
}

class Calculate{
    
    void Sum(int a,int b,int c,int d){
        int y = a+c;
        int z = b+d;
        System.out.println("The sum is " + y + "+" + z + "i");
    }
    void multiply(int a,int b,int c,int d){
        int y = a*c;
        int z = b*d;
        System.out.println("The multiplication is " + y + "+" + z + "i");
    }
    void division(int a,int b,int c,int d){
        int y = a/c;
        int z = b/d;
        System.out.println("The Division is " + y + "+" + z + "i");
    }
}
