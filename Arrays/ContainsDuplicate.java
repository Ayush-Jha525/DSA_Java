//Question: Return true if any value appears at least twice in the array, and return false if every element is distinct.
//Time Complexity : O(n)
//Space Complexity : O(n) 
package Arrays;

import java.util.*;

public class ContainsDuplicate {
    public static boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            // if number already present in set add returns false
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4 };
        int[] nums2 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        System.out.println(hasDuplicate(nums1));
        System.out.println(hasDuplicate(nums2));

    }
}
