//Question : Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//  A subarray is a contiguous non-empty sequence of elements within an array.
//Time Complexity : O(n)
//Space Complexity : O(n)
package Hashing;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<>();

        int prefixSum = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (frequency.containsKey(prefixSum - k)) {
                result += frequency.get(prefixSum - k);
            }

            if (prefixSum == k) {
                result++;
            }

            if (frequency.containsKey(prefixSum)) {
                frequency.put(prefixSum, frequency.get(prefixSum) + 1);
            } else {
                frequency.put(prefixSum, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }
}
