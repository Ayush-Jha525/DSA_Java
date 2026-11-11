/*Question : Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote. */
//Time Complexity : O(n)
//Space Complexity : O(1)
package Strings;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (char i : magazine.toCharArray()) {
            int idx = i - 'a';
            freq[idx]++;
        }

        for (char i : ransomNote.toCharArray()) {
            int idx = i - 'a';
            if (freq[idx] != 0) {
                freq[idx]--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine)); // output : false

        ransomNote = "aa";
        magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine)); // output : true
    }
}
