//Question : You are given two integer arrays nums1 and nums2, where nums1 is a subset of nums2.
//      For each element in nums1, find the first greater element to its right in nums2.
//      If there is no greater element, return -1.
//      Return the answers in the same order as nums1.
// Time Complexity : O(n + m)           * n = nums2.length
//Space complexity : O(n)               * m = nums1.length
package Stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement_I {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> nextGreater = new Stack<>();
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!nextGreater.isEmpty() && nextGreater.peek() <= nums2[i]) {
                nextGreater.pop();
            }
            int val = (nextGreater.isEmpty()) ? -1 : nextGreater.peek();
            map.put(nums2[i], val);
            nextGreater.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        int[] result = nextGreaterElement(nums1, nums2);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
