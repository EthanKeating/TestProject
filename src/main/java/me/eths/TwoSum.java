package me.eths;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = {10, 20, 5, 0, -1, 30};

        int targetSum = 50;

        long start = System.currentTimeMillis();
        int[] results = getPair(nums, targetSum);
        System.out.println("Results are: " + results[0] + ", " + results[1]);
        System.out.println("Took " + (System.currentTimeMillis() - start) + "ms to run");

        long start2 = System.currentTimeMillis();
        int[] results2 = getPairOptimized(nums, targetSum);
        System.out.println("Optimized Results are: " + results2[0] + ", " + results2[1]);
        System.out.println("Took " + (System.currentTimeMillis() - start2) + "ms to run");
    }

    public static int[] getPair(int[] nums, int targetSum) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == targetSum) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] { -1, -1 };
    }

    public static int[] getPairOptimized(int[] nums, int targetSum) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if (sumMap.containsKey(nums[i]))
                return new int[] { sumMap.get(nums[i]), i };

            sumMap.put(targetSum - nums[i], i);
        }

        return new int[] { -1, -1 };
    }

}
