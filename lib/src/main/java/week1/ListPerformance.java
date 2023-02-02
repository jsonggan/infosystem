package week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListPerformance {
    public static void main(String[] args) {
        Integer[] a = new Integer[50000]; // array of Integer
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(a));  // Create ArrayList from the array of Integer
        LinkedList<Integer> linList = new LinkedList<>(Arrays.asList(a));  // Create LinkedList from the array of Integer

        int count = 100000; // number of times item get accessed

        System.out.println("\nAccess the middle item of the list");
        System.out.println("ArrayList: "+  accessTime(arrList, count, arrList.size()/2) + " seconds");
        System.out.println("LinkedList: "+  accessTime(linList, count, linList.size()/2) + " seconds");

        System.out.println("\nAccess the last item of the list");
        System.out.println("ArrayList: "+  accessTime(arrList, count, arrList.size()-1) + " seconds");
        System.out.println("LinkedList: "+  accessTime(linList, count, linList.size()-1) + " seconds");

        System.out.println("\nInsert item somewhere in the middle of the list");
        System.out.println("ArrayList: "+  insertTime(arrList, count, arrList.size()/2) + " seconds");
        System.out.println("LinkedList: "+  insertTime(linList, count, linList.size()/2) + " seconds");

        System.out.println("\nInsert item at the beginning of the list");
        System.out.println("ArrayList: "+  insertTime(arrList, count, 0) + " seconds");
        System.out.println("LinkedList: "+  insertTime(linList, count, 0) + " seconds");
    }

    static double accessTime(List list, int count, int idx) {
        long started = System.nanoTime();  // starting time. nanotime() is used to calculate duration between start-end

        for (int k=0; k<count; k++) {
            list.get(idx);
        }
        long ended = System.nanoTime(); // stopping time
        double d = (ended-started)/Math.pow(10, 9); // duration = stopping - starting time
        return d;
    }

    static double insertTime(List list, int count, int idx) {
        long started = System.nanoTime();  // starting time. nanotime() is used to calculate duration between start-end

        for (int k=0; k<count; k++) {
            list.add(idx, 123 );
        }
        long ended = System.nanoTime();
        double d = (ended-started)/Math.pow(10, 9);
        return d;
    }


}
