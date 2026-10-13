/*Question : Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums. */
//Time Complexity : O(n)
//Space Complexity : O(1)
package Arrays;

import java.util.*;

public class FindAllNumbersDisappearedInArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i : nums) {
            int idx = Math.abs(i) - 1;
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }
        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing.add(i + 1);
            }
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 1, 3, 2, 7, 8, 2, 3 };
        System.out.println(findDisappearedNumbers(arr));
    }
}
