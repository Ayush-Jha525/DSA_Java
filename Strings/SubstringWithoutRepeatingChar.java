//Question : Find the length of the longest substring without duplicate characters.
//Time Complexity : O(n)
//Space Complexity : O(n)
package Strings;

import java.util.*;

public class SubstringWithoutRepeatingChar {
    public static int longestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int front = 0;

        for (int rear = 0; rear < s.length(); rear++) {
            char c = s.charAt(rear);

            if (map.containsKey(c) && map.get(c) >= front) {
                front = map.get(c) + 1;
            }
            longest = Math.max(longest, rear - front + 1);
            map.put(c, rear);
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(longestSubstring(s));
    }
}
