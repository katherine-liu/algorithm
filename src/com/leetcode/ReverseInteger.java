package com.leetcode;

import java.util.Stack;

public class ReverseInteger {
    public static void main (String[] args) {
        int number = -214748364;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse2(number));
    }

    public static int reverse (int x) {
        boolean isNegative = x < 0;
        if (isNegative) {
            x  = -x;
        }
        int result = 0;
        int maxNum = Integer.MAX_VALUE / 10;
        while(x > 0) {
            int remain = x % 10;
            x /= 10;
            if (result > maxNum) {
                return 0;
            }
            result = result * 10 + remain;
        }

        return result;
    }

//    Use stack
    public static int reverse2 (int x) {
        if (x > Integer.MAX_VALUE) {
            return 0;
        }
        boolean isNegative = x < 0;
        if (isNegative) {
            x = -x;
        }
        char[] chars = ("" + x).toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            st.push(chars[i]);
        }
        char[] tempChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            tempChars[i] = st.pop();
        }
        int result = Integer.parseInt(String.valueOf(tempChars));
        result = isNegative ? -result : result;
        return result;
    }
}
