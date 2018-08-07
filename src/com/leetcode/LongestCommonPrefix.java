package com.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main (String[] args) {
        String[] s = new String[]{"dog","racecar","car"};
//        String[] s = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(s));
        System.out.println(longestCommonPrefix2(s));
    }

    public static String longestCommonPrefix (String[] s) {
        StringBuilder commonPrefix = new StringBuilder();
        if (s.length > 1 && s != null) {
            Arrays.sort(s);
            char[] a = s[0].toCharArray();
            char[] b = s[s.length - 1].toCharArray();
            for (int i = 0; i < s.length; i++) {
                if (a[i] == b[i] && s.length > i) {
                    commonPrefix.append(b[i]);
                } else {
                    return commonPrefix.toString();
                }

            }
        }

        return commonPrefix.toString();
    }

    public static String longestCommonPrefix2 (String[] s) {
        if (s == null || s.length == 0) return "";
        int i = 1;
        String pre = s[0];
        while (i < s.length) {
            while (s[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                if (pre.length() == 0) return "";
            }
            i++;
        }
        return pre;
    }
}
