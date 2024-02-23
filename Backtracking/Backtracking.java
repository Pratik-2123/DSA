public class Backtracking {
    public static void ChangeArr(int arr[], int i, int val) {   //Backtracking of an Array        TC = O(n) SC = O(n)
        //Base case
        if(i == arr.length) {
          printArr(arr);
          return;
        }

        //Recursion (kaam)
        arr[i] = val;
        ChangeArr(arr, i+1, val+1);                           //Recursion call
        arr[i] = arr[i] - 2;                                  //Backtracking step

    }

    public static void FindSubsets(String str, String news_s,int i){
         //Base Case
         if(i == str.length()){
            if(news_s.length() == 0) {
                System.out.println("NULL");
            } else {
                System.out.println(news_s);
            }
            return;   
         }

         //Recursion kaam 
         //Yes case 
         FindSubsets(str, news_s+str.charAt(i), i+1);
         //No case
         FindSubsets(str, news_s,i+1);
    }

    public static void FindPermutation(String str, String ans) {
        //Base Case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        //recursion
        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);

            FindPermutation(newStr, ans+curr);
        }
    }
    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int gridWays(int i, int j, int n, int m){
        //base cases
        if(i == n-1 && j == m-1) {
            return 1;
        } else if(i == n || j == m) {
            return 0;
        }

        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);
        return w1 + w2;
    }

    public static int fact(int x) {
        int fact = 1;
        for(int i=1; i<=x; i++) {
            fact = fact * i;
        }

        return fact;
    }
    public static void main(String args[]) {
        // int arr[] = new int[5];                Backtracking of an array
        // ChangeArr(arr, 0, 1);
        // printArr(arr);

        // String str = "abc";                    Finding Subsets of a String
        // FindSubsets(str,"",0);
        

        // String str = "abc";                    Finding the permutation of the string
        // FindPermutation(str,"");
        
        // int n = 3 , m = 3;                     GridWays
        // System.out.println("The total number of ways are : " + gridWays(0, 0, n, m));

        // int n = 3, m = 3;
        // int num = n-1+m-1;                     Gridways Optimized Code using Permutation
        // int total = (fact(num))/(fact(n-1)*fact(m-1));
        // System.out.println(total);

        
    }
}
