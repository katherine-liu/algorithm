package com.classicproblems;

public class EightQueens {
    public static void main (String[] args) {
        EightQueens eightQueens = new EightQueens();
        int[] queens = new int[8];
//        eightQueens.queens(8, 0, queens);
        eightQueens.queens1(8, 0, queens);
    }

    boolean hasResult = false;
    int count = 0;
//    for all valid results
    public void queens (int n, int currentRow, int[] results) {
        if (currentRow == n) {
            count++;
            System.out.println("The " + count + "th result is ");
            print(results);
            return;
        }
        for (int i = 0; i < n; i++) {
            results[currentRow] = i;
            if (isValid(currentRow, results)) {
                queens(n, currentRow + 1, results);
            }
        }
    }

//    for the first valid result
    public void queens1 (int n, int currentRow, int[] results) {
        if (currentRow == n) {
            hasResult = true;
            print(results);
            return;
        }
//        loop columns
        for (int i = 0; i < n; i++) {
            if (hasResult) break;
            results[currentRow] = i;
            if (isValid(currentRow, results)) {
                queens1(n, currentRow + 1, results);
            }
        }
    }

    public boolean isValid (int row, int[] results) {
        for (int i = 0; i < row; i++) {
            if (results[row] == results[i] || Math.abs(results[i] - results[row]) == (row - i)) {
                return false;
            }
        }
        return true;
    }

    public void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j == arr[i]) {
                    System.out.print("*");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }


}
