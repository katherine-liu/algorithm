package com.leetcode;
import java.util.Stack;

public class PalindromeNumber {

    public static void main (String[] args) {
        System.out.println(isPalindrome2(-22));
    }

    public static boolean isPalindrome (int x) {
        String num = Integer.toString(x);
        if (num.length() <= 1) {
            return true;
        }
        char start = num.charAt(0);
        char end = num.charAt(num.length() - 1);
        if (start != end) {
            return false;
        } else if (start == end) {
            isPalindrome(Integer.parseInt(num.substring(1, (num.length() - 1))));
        }
        return true;
    }

//    Use stack
    public static boolean isPalindrome2 (int x) {
        char[] chars = ("" + x).toCharArray();
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < chars.length; i++) {
            st.push(chars[i]);
        }
        char[] tempChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            tempChars[i] = st.pop();
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == tempChars[i]) {

            } else {
                return false;
            }
        }

        return true;

    }
}
