//Question: Check if Two Strings are Anagrams
//      * Two strings are anagrams if they contain the same characters with the same frequencies, regardless of their order.
//      * Note : Strings contain only lowercase English letters ('a' to 'z')
//Time Complexity : O(n)
//Space Complexity : O(1)
package Strings;

public class CheckAnagram {
    public static boolean isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (char i : str1.toCharArray()) {
            freq[i - 'a'] += 1;
        }

        for (char i : str2.toCharArray()) {
            freq[i - 'a'] -= 1;
        }

        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "rat";
        String str2 = "cat";

        System.out.println(isAnagram(str1, str2));
    }
}
