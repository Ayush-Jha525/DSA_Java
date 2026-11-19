/*Question : Given an array arr[] containing distinct positive integers, and two integers start and end defining a range. Find if the array contains all elements within inclusive range [start, end].*/
//Time Complexity : O(n) 
//Space Complexity : O(n)
package Arrays;

import java.util.HashSet;

public class ElementsinRange {
    public static boolean checkElements(int start, int end, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        for (int i = start; i <= end; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int start = 2;
        int end = 5;
        int[] arr = { 1, 4, 5, 2, 7, 8, 3 };
        System.out.println(checkElements(start, end, arr));

        start = 2;
        end = 6;
        arr = new int[] { 1, 4, 5, 2, 7, 8, 3 };
        System.out.println(checkElements(start, end, arr));
    }
}
