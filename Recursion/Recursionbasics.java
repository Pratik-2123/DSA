package Recursion;

public class Recursionbasics {
    // Code for Calculating the Sum of the first n natural numbers
    public static int CalcSum(int n) {
        if(n == 1) {
            return 1;
        }
        int Snm1 = CalcSum(n-1);
        int Sn = n + Snm1;
        return Sn;
    }

    // Code for printing the Nth Fibonacci number
    public static int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    // Code to check wheather the Array is sorted or not 
    public static boolean isSorted(int a[] , int i) {
        if( i == a.length-1 ) {   // Base case
            return true;
        }
        if(a[i] > a[i+1]) {
            return false;
        }
        return isSorted(a,i+1);
    }

    // Function to find the first occurance of an element 
    public static int firstOccurance(int arr[], int i , int key) {
        if(i == arr.length-1) {
            return -1;
        }
        if(arr[i] == key) {
            return i;
        }
        return firstOccurance(arr, i+1, key);
    }

    // Function to find the last occurance of an element
    public static int lastOccurance(int arr[], int key , int i) {
        if(i == arr.length-1) {
            return -1;
        }

        int isFound = lastOccurance(arr, key, i+1);

        if(isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;
    }

    // Function to Print x^n
    public static int Pow(int x , int n) {
        if(n == 0) {
            return 1;
        }
        return x * Pow(x,n-1);
    }

    // Function to print x^n in optimized way
    public static int OptimizedPower(int x, int n) {
        if( n == 0 ) {            // Base Case
            return 1;
        }
        
        //int halfpowersquare = OptimizedPowe(x,n/2) * OptimizedPowe(x,n/2);
        // This Statement is also true but in this case the time complexity will remain O(n)

         int halfPower = OptimizedPower(x, n/2);         // But in this case the time complexity will reduce and become O(log n)
         int halfPowersquare = halfPower * halfPower; 

        if(n % 2 != 0) {
            return x * halfPowersquare;
        }
        return halfPowersquare;
    }

    // Most important Tiling Problem asked in Amazon various number of times
    public static int TilingProblem(int n) {
        // Base case
        if(n == 0 || n == 1) {
            return 1;
        }

        //kaam 
        //vertical choice
        int fnm1 = TilingProblem(n-1);
        //Horizontal Choice
        int fnm2 = TilingProblem(n-2);

        int totways = fnm1 + fnm2;
        return totways;
    }

    // Code to remove the duplicates from the string
    public static void RemoveDuplicates(String str , int index, StringBuilder newStr , boolean map[]) {
        if(index == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currchar = str.charAt(index);
        if(map[currchar - 'a'] == true) {
            //duplicate
            RemoveDuplicates(str, index+1, newStr, map);
        } else {
            //not a duplicate
            map[currchar - 'a'] = true;
            RemoveDuplicates(str, index+1, newStr.append(currchar), map);
        }
    }

    // Code for the Friends Pairing Problem 
    public static int FriendsPairing(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        // choice 
        // Single
        // int fnm1 = FriendsPairing(n-1);

        // Pair
        // int fnm2 = FriendsPairing(n-2);
        // int pairways = (n-1) * fnm2;

        // int totways = fnm1 + pairways;
        return FriendsPairing(n-1) + (n-1) * FriendsPairing(n-2);
    }

    // Code to Print all the binary strings of size n without consequtive ones
    public static void PrintBinStr(int n , int lastplace , String str) {
        if(n == 0) {
            System.out.print(str+" ");
            return;
        }

        // if(lastplace == 0){
        //     PrintBinStr(n-1, 0, str+"0");
        //     PrintBinStr(n-1, 1, str+"1");
        // } else {
        //     PrintBinStr(n-1, 0, str+"0");
        // }
        
        PrintBinStr(n-1, 0, str+"0");
        if(lastplace == 0){
            PrintBinStr(n-1, 1, str+"1");
        }
    }

    public static void main(String args[]) {
        PrintBinStr(3, 1,"");
    }
}
