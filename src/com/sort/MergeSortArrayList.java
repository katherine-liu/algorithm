package com.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeSortArrayList {
    public static void main (String[] args) {
        Scanner reader = new Scanner(System.in);
        List<Integer> list = new ArrayList<Integer>();
        System.out.println("Enter a number: ");
        int input = reader.nextInt(); // Scans the next token of the input as an int.

        while (input != 00) {
            list.add(input);
            input = reader.nextInt();
        }
        reader.close(); //once finished
        List<Integer> res = new ArrayList<Integer>();
        res = sortList(list);
        printList(res);
    }

    public static void printList (List<Integer> list) {
        System.out.println("----------------------------------------------");
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static List<Integer> sortList (List<Integer> list) {
        // base case
        if(list.size() <= 1)
            return list;

        int m = list.size() / 2;
        List<Integer> leftSortedSeq = sortList(list.subList(0, m));
        List<Integer> rightSortedSeq = sortList(list.subList(m, list.size()));
        return merge(leftSortedSeq, rightSortedSeq);
    }

    public static List<Integer> merge (List<Integer> leftSortedSeq, List<Integer> rightSortedSeq) {
        if (leftSortedSeq.isEmpty()) {
            return rightSortedSeq;
        } else if (rightSortedSeq.isEmpty()) {
            return leftSortedSeq;
        }
        List<Integer> sortedSeq = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0, leftSize = leftSortedSeq.size(), rightSize = rightSortedSeq.size();
        while (leftIndex < leftSize && rightIndex < rightSize) {
            Integer leftSmallestElem = leftSortedSeq.get(leftIndex);
            Integer rightSmallestElem = rightSortedSeq.get(rightIndex);
            if (leftSmallestElem <= rightSmallestElem) {
                sortedSeq.add(leftSmallestElem);
                leftIndex++;
            } else {
                sortedSeq.add(rightSmallestElem);
                rightIndex++;
            }
        }
        sortedSeq.addAll(leftSortedSeq.subList(leftIndex, leftSize));
        sortedSeq.addAll(rightSortedSeq.subList(rightIndex, rightSize));

//        printList(sortedSeq);
        return sortedSeq;
    }
}
