//Question : Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
//Time Complexity : O(n+m);                     //n : length of arr1
//Space Complexity : O(min(n,m));               //m : length of arr2

package Arrays;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        int[] small;
        int[] big;
        if (arr1.length < arr2.length) {
            small = arr1;
            big = arr2;
        } else {
            small = arr2;
            big = arr1;
        }

        int[] intersect = new int[small.length];
        int idx = 0;

        for (int i : small) {
            set.add(i);
        }

        for (int i : big) {
            if (set.contains(i)) {
                intersect[idx++] = i;
                set.remove(i);
            }
        }

        return Arrays.copyOf(intersect, idx);
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 3, 1 };
        int[] arr2 = { 2, 2, 3, 3 };

        int[] result = intersection(arr1, arr2);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
