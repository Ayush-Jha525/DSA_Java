/*Queution : You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window. */
// Time Complexity : O(n)
// Space Complexity : O(n)
package Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return new int[] { nums[0] };
        }
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;

        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }

        for (int i = k; i < n; ++i) {

            result.add(nums[deque.peekFirst()]);

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        result.add(nums[deque.peekFirst()]);

        int[] maxNum = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            maxNum[i] = result.get(i);
        }

        return maxNum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        int[] res = maxSlidingWindow(arr, k);
        for (int maxVal : res) {
            System.out.print(maxVal + " ");
        }
    }
}
