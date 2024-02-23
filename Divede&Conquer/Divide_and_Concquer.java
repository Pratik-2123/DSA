  public class Divide_and_Concquer {
    public static void printarr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    

    //Merge sort ka Merge part i.e 3rd part
    public static void Merge(int arr[], int si, int ei, int mid) {
        //left(0,2)=3  right(3,5)=3  ei-si+1=  5-0+1  = 6
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= ei) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //left
        while(i<=mid) {
            temp[k++] = arr[i++];
        }

        //right
        while(j<=ei) {
            temp[k++] = arr[j++];
        }

        // Copy temp array into the main array
        for(k=0 , i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    //Merge Sort Function 1st and 2nd part
    public static void MergeSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }

        int mid = si+(ei-si)/2;
        MergeSort(arr, si, mid);
        MergeSort(arr, mid+1, ei);
        Merge(arr, si, ei, mid);
    }

    // Code For quick sort
    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }

        int pidx = partition(arr,si,ei);
        quickSort(arr, si, pidx-1);   //left
        quickSort(arr, pidx+1, ei); //right

    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si-1; //Iterator that makes place for the elements that are smaller then pivot

        for(int j=si; j<arr.length; j++) {
            if(arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp; 

        return i;
    }

    // Code to search a rotated Sorted array // also known as the modified binary search using recursion
    public static int Search(int arr[] , int target, int si, int ei) {         //Modified Binary Search
        if(si > ei) {  // Base case
            return -1;
        }
        
        int mid = si + (ei-si)/2;

        if(arr[mid] == target) {
            return mid;
        }
 
        //mid on line 1
        if(arr[si] <= arr[mid]) {
            //case a
            if(arr[si] <= target && target <= arr[mid]) {
                return Search(arr, target, si, mid-1);
            } else {
                //case b
                return Search(arr, target, mid+1, ei);
            }
        } else {
            // mid on line 2 
            if(arr[mid] <= target && target <= arr[ei]) {
                //case c
                return Search(arr, target, mid+1, ei);
            } else {
                //case d
                return Search(arr, target, si, mid-1);
            }

        }
    }
    public static void main(String args[]) {
        // int arr[] ={6,3,9,7,5,2,8};
        // MergeSort(arr, 0, arr.length-1);
        // printarr(arr);

        // int arr[] ={6,3,9,8,2,5};
        // quickSort(arr, 0, arr.length-1);
        // printarr(arr);

        int arr[] = {4,5,6,7,0,1,2};
        int target = 2;
        int tarIdx = Search(arr, target, 0, arr.length-1);
        System.out.println("The target is Present at Index : " + tarIdx);
        

    }  
}
