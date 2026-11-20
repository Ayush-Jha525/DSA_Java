/*Question : Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.*/
//Time Complexity : O(n) 
//Space Complexity : O(1)
package Strings;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s)); // -1

        s = "envelope";
        System.out.println(firstUniqChar(s)); // 1
    }
}
