//Question : Given an integer array nums and an integer k, return the length of the longest contiguous subarray whose sum equals k.
//  If there is no such subarray, return 0.
//Time Complexity : O(n)
//Space Complexity : O(n)
package Hashing;

import java.util.HashMap;

public class LongestSubarrayWithSumK {
    public static int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> seenPrefix = new HashMap<>();
        int maxLength = 0;
        int prefixSum = 0;
        seenPrefix.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (seenPrefix.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, i - seenPrefix.get(prefixSum - k));
            }
            if (!seenPrefix.containsKey(prefixSum)) {
                seenPrefix.put(prefixSum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, -10 };
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }
}
