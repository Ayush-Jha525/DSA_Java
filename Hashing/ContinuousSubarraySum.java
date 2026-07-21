//Question : Given an integer array nums and an integer k, return true if the array has a continuous subarray of size at least 2 whose sum is a multiple of k
//Time  : O(n)
//Space : O(min(n, k))
package Hashing;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> seenRemainder = new HashMap<>();
        int prefix = 0;
        seenRemainder.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            int remainder = prefix % k;
            if (seenRemainder.containsKey(remainder)) {
                if (i - (seenRemainder.get(remainder)) >= 2) {
                    return true;
                }
            } else {
                seenRemainder.put(remainder, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = { 23, 2, 4, 6, 7 };
        int k = 6;

        System.out.println(checkSubarraySum(num, k));
    }
}
