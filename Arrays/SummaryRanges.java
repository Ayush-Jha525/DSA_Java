/*Question : You are given a sorted unique integer array nums.
    A range [a,b] is the set of all integers from a to b (inclusive).
    Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

    Each range [a,b] in the list should be output as:
        *   "a->b" if a != b
        *   "a" if a == b*/
//Time Complexity : O(n) 
//Space Complexity : O(1)
package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int a = nums[0];
        int current = a;
        int i = 1;
        while (i <= nums.length) {
            if (i < nums.length && current + 1 == nums[i]) {
                i++;
                current++;
                continue;
            }
            int b = nums[i - 1];
            if (a == b) {
                result.add(String.valueOf(a));
            } else {
                result.add(String.valueOf(a) + "->" + String.valueOf(b));
            }
            if (i != nums.length) {
                a = nums[i];
                current = a;
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -5, -4, -2, -1, 0, 1, 2 };
        System.out.println(summaryRanges(nums));

        nums = new int[] { -1 };
        System.out.println(summaryRanges(nums));

        nums = new int[] {};
        System.out.println(summaryRanges(nums));

        nums = new int[] { 0, 2, 3, 4, 6, 8, 9 };
        System.out.println(summaryRanges(nums));

    }
}
