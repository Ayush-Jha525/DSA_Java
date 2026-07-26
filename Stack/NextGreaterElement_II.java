//Question : Given a circular integer array nums (the next element of the last element is the first element of the array), return the next greater element for every element.
// Time Complexity : O(n)
//Space complexity : O(n) 
package Stack;

import java.util.Stack;

public class NextGreaterElement_II {
    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int idx = i % nums.length;

            while (!stack.isEmpty() && stack.peek() <= nums[idx]) {
                stack.pop();
            }
            result[idx] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(nums[idx]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 3 };
        int[] result = nextGreaterElements(nums);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
