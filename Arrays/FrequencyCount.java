//Question : Given an array of integers, count how many times each distinct element appears in the array.
//Time Complexity : O(n);
//Space Complexity : O(n);
package Arrays;

import java.util.HashMap;

public class FrequencyCount {
    public static HashMap<Integer, Integer> countFrequency(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 1, 4, 5, 2, 2, 1, 2, 3 };

        HashMap<Integer, Integer> result = countFrequency(arr);

        for (int i : arr) {
            if (result.containsKey(i)) {
                System.out.println(i + " -> " + result.get(i));
                result.remove(i);
            }
        }
    }
}
