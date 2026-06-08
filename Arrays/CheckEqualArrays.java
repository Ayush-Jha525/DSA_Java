//Question - Given two arrays a[] and b[], find whether the elements in the arrays are equal.
//Time Complexity - O(n)                  
//Space Complexity - O(n)            
package Arrays;

import java.util.*;

public class CheckEqualArrays {
    public static boolean EqualArray(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        // Adding value with its frequency
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }

        for (int i = 0; i < b.length; i++) {
            if (map.containsKey(b[i])) {
                if (map.get(b[i]) == 1) {
                    map.remove(b[i]);
                } else {
                    map.put(b[i], map.get(b[i]) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 5, 4, 2, 0 };
        int b[] = { 2, 4, 2, 5, 0, 1 };

        System.out.println(EqualArray(a, b));
    }
}
