//Question: Given an array of integers (which may contain positive, negative, and zero values), find the maximum possible sum of any contiguous subarray.
//Time Complexity : O(n)
//Space Complexity : O(1) 
package Arrays;

public class MaximumSubArraySum {
    // Using Kadane's algorithm
    public static int maxSum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int max = arr[0];
        int current = arr[0];

        for (int i = 1; i < arr.length; i++) {
            current = Math.max(arr[i], current + arr[i]);
            max = Math.max(current, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { -2, -3, -1, -5 };

        System.out.println(maxSum(arr));

    }
}