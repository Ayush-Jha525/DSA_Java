//Question : Given an integer array nums and an integer target, return the indices of the two numbers such that they add up to target
//Time Complexity : O(n)
//Space Complexity : O(n)
package Hashing;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> seenValues = new HashMap<>();

        int required = 0;
        for (int i = 0; i < nums.length; i++) {
            required = target - nums[i];
            if (seenValues.containsKey(required)) {
                result[0] = seenValues.get(required);
                result[1] = i;
                break;
            } else {
                seenValues.put(nums[i], i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = twoSum(arr, target);
        for (int i : result) {
            System.out.println(i + " ");
        }
    }
}
