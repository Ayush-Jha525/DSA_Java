//Question : Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
//Time Complexity : O(n)
//Space Complexity : O(n)
package Hashing;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramInString {
    public static boolean isAnagram(int[] freqP, int[] freqS) {
        for (int i = 0; i < 26; i++) {
            if (freqP[i] != freqS[i]) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int[] freqP = new int[26];
        int[] freqS = new int[26];
        int start = 0;

        for (char c : p.toCharArray()) {
            freqP[c - 'a'] += 1;
        }

        for (int i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - 'a']++;
            if (i - start == p.length() - 1) {
                if (isAnagram(freqP, freqS)) {
                    result.add(start);
                }
                freqS[s.charAt(start) - 'a']--;
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> result = findAnagrams(s, p);
        for (int i : result) {
            System.out.println(i + " ");
        }
    }
}
