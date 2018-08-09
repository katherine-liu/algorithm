package com.classicproblems;

public class EightQueens {
    public static void main (String[] args) {
        EightQueens eightQueens = new EightQueens();
        int[] queens = new int[8];
        int count = 0;
        eightQueens.queens(8, 0, queens, count);
//        eightQueens.queens1(8, 0, queens);
    }

//    for all valid results
    public int queens (int n, int currentRow, int[] results, int count) {
        if (currentRow == n) {
            count++;
            System.out.println("The " + count + "th result is ");
            print(results);
            return count;
        }
        for (int i = 0; i < n; i++) {
            results[currentRow] = i;
            if (isValid(currentRow, results)) {
                count = queens(n, currentRow + 1, results, count);
            }
        }
        return count;
    }

//    for the first valid result
    public boolean queens1 (int n, int currentRow, int[] results) {
        if (currentRow == n) {
            print(results);
            return true;
        }
//        loop columns
        for (int i = 0; i < n; i++) {
            results[currentRow] = i;
            if (isValid(currentRow, results)) {
                if (queens1(n, currentRow + 1, results)) return true;
            }
        }
        return false;
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
