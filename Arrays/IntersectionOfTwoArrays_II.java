//Question : Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
//Time Complexity : O(n+m);                     //n : length of arr1
//Space Complexity : O(min(n,m));               //m : length of arr2

package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArrays_II {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] small;
        int[] big;
        if (nums1.length < nums2.length) {
            small = nums1;
            big = nums2;
        } else {
            small = nums2;
            big = nums1;
        }

        int[] intersect = new int[small.length];
        int idx = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < small.length; i++) {
            if (map.containsKey(small[i])) {
                map.put(small[i], map.get(small[i]) + 1);
            } else {
                map.put(small[i], 1);
            }
        }

        for (int i : big) {
            if (map.containsKey(i)) {
                intersect[idx++] = i;
                if (map.get(i) != 1) {
                    map.put(i, map.get(i) - 1);
                } else {
                    map.remove(i);
                }
            }
        }
        return Arrays.copyOf(intersect, idx);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 3, 1 };
        int[] arr2 = { 2, 2, 3, 3 };

        int[] result = intersect(arr1, arr2);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
