//Question - TwoSum : Given an array of integers and a target value, return the indices of the two numbers whose sum equals the target.
//Time Complexity - O(n)
//Space Complexity - O(n)
package Arrays;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int required = target - arr[i];

            // required number is seen earlier?
            if (seen.containsKey(required)) {
                return new int[] { seen.get(required), i };
            } else {
                seen.put(arr[i], i);
            }
        }
        // if no pair found
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int[] result = twoSum(arr, 9);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
