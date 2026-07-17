//Question : Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
//Time Complexity : O(n)
//Space Complexity : O(1) 
package Arrays;

public class MaxSubarraySumOfSizeK {
    public static int maxSubarraySum(int[] arr, int k) {
        int start = 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (i - start + 1 == k) {
                max = Math.max(sum, max);
                sum -= arr[start];
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 100, 200, 300, 400 };
        int k = 2;
        System.out.println(maxSubarraySum(arr, k));
    }
}
