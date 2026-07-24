//Question : find the next greater element for each element of the array in order of their appearance in the array.
//Time complexity : O(n);
//Space complexity : O(n);
package Stack;

import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextLargerElement(int[] arr) {
        // code here
        int[] result = new int[arr.length];
        Stack<Integer> nextGreater = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!nextGreater.isEmpty() && nextGreater.peek() <= arr[i]) {
                nextGreater.pop();
            }

            if (!nextGreater.isEmpty()) {
                result[i] = nextGreater.peek();
            } else {
                result[i] = -1;
            }
            nextGreater.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 8, 0, 1, 3 };
        int[] result = nextLargerElement(arr);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
