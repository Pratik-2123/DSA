package Recursion;

public class Recursion_Questions {
    // Question 1 - Find all the occurances of the given key and print thier index's
    public static void PrintOccurances(int arr[] , int key , int idx) {
        if(idx == arr.length) {
            return;
        } 

        if(arr[idx] == key) {
            System.out.print(idx + " ");
            
        }
        PrintOccurances(arr, key, idx+1);
        
    }

    // Question 2 - Convert the given integer number into the format of english letters
    public static String digits[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};

    public static void PrintNuminletter(int number) {
        if(number == 0) {
            return;
        }

        int lastdigit = number%10;
        PrintNuminletter(number/10);
        System.out.print(digits[lastdigit] + " ");
        
    }

    // Question 3 - Function to find the length of the String using Recursion
    public static int LengthofString(String str) {
        if(str.length() == 0){
            return 0;
        }

        return LengthofString(str.substring(1)) + 1 ;
    }

    // Question 3 - 
    public static int Printcount(String str , int i) {
        if(str.length() == 0){
            return 0;
        }
        str.substring(i);
        return Printcount(str, i+1);
    }

    public static void main(String args[]) {
        // int arr[] = {3,2,4,5,6,2,7,2,2};    Question 1
        // PrintOccurances(arr, 2, 0);

        // PrintNuminletter(1234);    Question 2

        // System.out.println(LengthofString("abcd"));

        System.out.println(Printcount("aba", 0));
    }
}
