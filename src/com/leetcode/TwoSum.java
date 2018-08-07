package com.leetcode;

import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    public static void main (String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] res = new int[2];
        res = twoSum(arr, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println("The index is " + res[i]);
        }
    }
    public static int[] twoSum(int[] arr,  int target) {
        int[] result = new int[]{-1, -1};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            boolean hasKey = map.containsKey(target - arr[i]);
            if ( hasKey ) {
                result[0] = i;
                result[1] = map.get(target - arr[i]);
                System.out.println("First condition " + i);
                return result;
            } else {
                map.put(arr[i], i);
            }
        }
        return result;
    }
}
