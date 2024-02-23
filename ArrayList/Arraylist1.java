package ArrayList;

import java.util.ArrayList;

public class Arraylist1 {
    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2, temp);
    }
    public static void main(String args[]) {
        //Java collection Framework
        ArrayList<Integer> list  = new ArrayList<>();

        // //add element
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // System.out.println(list);

        // //get element
        // int ele = list.get(1);
        // System.out.println(ele);

        // //Remove element
        // list.remove(1);
        // System.out.println(list);

        // //set element at index
        // System.out.println(list);
        // list.set(1, 5);
        // System.out.println(list);

        // //Cointains Element
        // System.out.println(list.contains(0));
        // System.out.println(list.contains(1));


        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // System.out.println(list.size());

        
        // //Print reverse
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);
        // for(int i=list.size()-1; i>=0; i--) {
        //     System.out.print(list.get(i) + " ");
        // }


        // //Finding maximum in a ArrayList
        //     list.add(2);
        //     list.add(3);
        //     list.add(9);
        //     list.add(6);
        //     list.add(5);
        //     System.out.println("The orignal ArrayList is: " + list);
        //     int max = Integer.MIN_VALUE;
        //     for(int i=0; i<list.size(); i++) {
        //         max = Math.max(max, list.get(i));
        //     }
        //     System.out.println("The MAximum element is : " + max);

        
        // // Swapping the 2 numbers
        // list.add(2);
        // list.add(5);
        // list.add(9);
        // list.add(3);
        // list.add(6);
        // System.out.println(list);
        // int idx1 = 1, idx2 = 3;
        // swap(list, idx1, idx2);
        // System.out.println(list);
    }
}
