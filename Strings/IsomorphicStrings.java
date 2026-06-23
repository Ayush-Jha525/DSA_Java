//Question : Given two strings s and t, determine if they are isomorphic.
// *    Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//  *   All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//Time Complexity : O(n)
//Space Complexity : O(n) 
package Strings;

import java.util.*;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapS = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char char1 = s.charAt(i);
            char char2 = t.charAt(i);

            if (mapS.containsKey(char1)) {
                if (mapS.get(char1) != char2) {
                    return false;
                }
            } else {
                if (set.contains(char2)) {
                    return false;
                } else {
                    mapS.put(char1, char2);
                    set.add(char2);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";

        System.out.println(isIsomorphic(s, t));
    }

}
