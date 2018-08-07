package com.sort;

public class MergeSort {
    public static void main (String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    static void printArray (int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void sort (int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int m = (startIndex + endIndex) / 2;

            sort(arr, startIndex, m);
            sort(arr, m + 1, endIndex);
            merge(arr, startIndex, m, endIndex);
        }
    }

    public void merge (int[] arr, int startIndex, int m, int endIndex) {
        int nLeft = m - startIndex + 1;
        int nRight = endIndex - m;

        int L[] = new int [nLeft];
        int R[] = new int [nRight];

        for (int i=0; i < nLeft; ++i)
            L[i] = arr[startIndex + i];
        for (int j=0; j < nRight; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = startIndex;

        while (i < nLeft && j < nRight) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < nLeft) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < nRight) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
