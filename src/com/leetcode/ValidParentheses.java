package com.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main (String[] args) {
        System.out.println(validParentheses("[][]]{}()"));
    }

    public static boolean validParentheses (String s) {
        if (s == null || s.length() == 1) return false;
        char[] chars = s.toCharArray();
        char[] res = new char[s.length()];
        int head = 0;
        for (char c: chars) {
            switch (c) {
                case '(':
                case '[':
                case '{': res[head++] = c;
                case ')':
                    if (head == 0 || res[--head] != '(') return false;
                case ']':
                    if (head == 0 || res[--head] != '[') return false;
                case '}':
                    if (head == 0 || res[--head] != '{') return false;
            }
        }
        return true;
    }

//    Use Stack
    public static boolean validParentheses2 (String s) {
        Stack<Character> st = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(') st.push(')');
            else if (c == '[') st.push(']');
            else if (c == '{') st.push('}');
            else if (st.empty() || st.pop() != c) return false;
        }
        return true;
    }
}
