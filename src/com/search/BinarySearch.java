package com.search;

public class BinarySearch {
    public static void main (String[] args) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {2,3,4,10,40};
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr,0,n-1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

//    Recursive implementation of Binary Search
    public static int binarySearch (int[] arr, int startIndex, int endIndex, int x) {
        if (arr.length >= 1) {
            int m = (endIndex + startIndex) / 2;
            if (x == arr[m]) {
                return m;
            } else if (x < arr[m]) {
                return binarySearch(arr, startIndex, m, x);
            } else {
                return binarySearch(arr, m, endIndex, x);
            }
        } else {
            return -1;
        }
    }

//    Iterative implementation of Binary Search
    public static int binarySearch2 (int [] arr, int startIndx, int endIndex, int x) {

        return -1;

    }
}
