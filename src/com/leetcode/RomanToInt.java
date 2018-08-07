package com.leetcode;

public class RomanToInt {

    public static void main (String[] args) {
        System.out.println(RomanToInt("MCMXCIV"));
        System.out.println(RomanToInt2("MCMXCIV"));
    }

    public static int RomanToInt (String s) {
        int result = 0;
        char prev = 'A';
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'M': result += prev == 'C' ? 800 : 1000; break;
                case 'D': result += prev == 'C' ? 300 : 500; break;
                case 'C': result += prev == 'X' ? 80 : 100; break;
                case 'L': result += prev == 'X' ? 30 : 50; break;
                case 'X': result += prev == 'I' ? 8 : 10; break;
                case 'V': result += prev == 'I' ? 3 : 5; break;
                case 'I': result += 1; break;
            }
            prev = c;
        }
        return result;
    }

    public static int RomanToInt2 (String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[s.length()];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (chars[i]) {
                case 'M': nums[i] = 1000; break;
                case 'D': nums[i] = 500; break;
                case 'C': nums[i] = 100; break;
                case 'L': nums[i] = 50; break;
                case 'X': nums[i] = 10; break;
                case 'V': nums[i] = 5; break;
                case 'I': nums[i] = 1; break;
            }
        }
        for (int i = 0 ; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1]) {
                result -= nums[i];
            } else {
                result += nums[i];
            }
        }
        return (result + nums[nums.length - 1]);
    }
}
