//Question: Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.
// Time Complexity : O(n)
// Space Complexity : O(n)
package Stack;

import java.util.Stack;

public class Sumofsubarrayminimums {
    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && arr[s1.peek()] > arr[i]) {
                s1.pop();
            }
            left[i] = s1.isEmpty() ? (i + 1) : (i - s1.peek());
            s1.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!s2.isEmpty() && arr[s2.peek()] >= arr[i]) {
                s2.pop();
            }
            right[i] = s2.isEmpty() ? (n - i) : (s2.peek() - i);
            s2.push(i);
        }
        long MOD = 1_000_000_007L;
        long result = 0;
        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * left[i] * right[i];
            result = (result + contribution) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int[] arr = { 11, 81, 94, 43, 3 };
        System.out.println(sumSubarrayMins(arr));
    }
}
