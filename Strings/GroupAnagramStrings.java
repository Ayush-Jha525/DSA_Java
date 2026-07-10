//Question : Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//Time Complexity : O(n* k)        n = number of strings ,   k = average length of each string
//Space Complexity : O(n*k)
package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagramStrings {
    public static String getFrequencyKey(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        return Arrays.toString(freq);
    }

    public static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String s : arr) {
            String currentFreq = getFrequencyKey(s);
            if (map.containsKey(currentFreq)) {
                map.get(currentFreq).add(s);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(currentFreq, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] str = { "eat", "tea", "tan", "ate", "nat", "bat" };
        ArrayList<ArrayList<String>> result = anagrams(str);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j));
            }
            System.out.println();
        }
    }
}
