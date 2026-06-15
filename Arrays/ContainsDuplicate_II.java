//Question: Given an array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k
//Time Complexity : O(n)
//Space Complexity : O(n) 
package Arrays;

import java.util.HashMap;

public class ContainsDuplicate_II {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                if (i - j <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 0, 1, 1 }; // output : true
        int k1 = 1;
        System.out.println(containsNearbyDuplicate(arr1, k1));

        int[] arr2 = { 1, 2, 3, 1, 2, 3 }; // output : false
        int k2 = 2;
        System.out.println(containsNearbyDuplicate(arr2, k2));
    }
}
