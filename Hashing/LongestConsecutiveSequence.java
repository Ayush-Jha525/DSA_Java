//Question : Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence. You must write an algorithm that runs in O(n) time.
//Time Complexity : O(n)
//Space Complexity : O(n)

package Hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }
        int max = 0;

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int current = i;
                int count = 0;

                while (set.contains(current)) {
                    count++;
                    current++;
                }

                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };

        System.out.println(longestConsecutive(nums));
    }
}
