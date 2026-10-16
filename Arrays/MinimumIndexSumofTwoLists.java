/*Question : Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums. */
//Time Complexity : O(n+m)      n: list1.size, m:list2.size
//Space Complexity : O(min(n,m))
package Arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumIndexSumofTwoLists {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        String[] smaller, larger;
        if (list1.length < list2.length) {
            smaller = list1;
            larger = list2;
        } else {
            smaller = list2;
            larger = list1;
        }

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        int minIdx = Integer.MAX_VALUE;

        for (int i = 0; i < smaller.length; i++) {
            map.put(smaller[i], i);
        }

        for (int i = 0; i < larger.length; i++) {
            if (map.containsKey(larger[i])) {
                int idxSum = i + map.get(larger[i]);

                if (idxSum < minIdx) {
                    minIdx = idxSum;
                    result.clear();
                    result.add(larger[i]);
                } else if (idxSum == minIdx) {
                    result.add(larger[i]);
                }
            }
        }

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] list1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] list2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };

        String[] result = findRestaurant(list1, list2);
        for (String i : result) {
            System.out.println(i + " , ");
        }
    }
}
