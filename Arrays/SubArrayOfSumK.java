//Question - Given an array of positive integers and an integer K, find the length of the longest contiguous subarray whose sum is exactly K
// Time Complexity - O(n)
// Space Complexity - O(1)
package Arrays;

public class SubArrayOfSumK {
    public static int arrayOfSumK(int[] arr, int k) {
        int max = 0;
        int start = 0;
        int sum = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > k) {
                sum -= arr[start];
                start++;
            }
            if (sum == k) {
                max = Math.max(max, end - start + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 1, 1, 1 }; // output : 3 [1,1,1]
        int k = 3;

        System.out.println(arrayOfSumK(arr, k));
    }

}
