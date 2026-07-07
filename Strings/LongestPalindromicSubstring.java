//Question : Given a string s, return the longest palindromic substring in s.
//Time Complexity : O(n^2)
//Space Complexity : O(1)
package Strings;

public class LongestPalindromicSubstring {
    public static String palindrome(String str, int i, int j) {
        while (i >= 0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            i--;
            j++;
        }
        i++;
        return str.substring(i, j);
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            // for odd
            String oddLength = palindrome(s, i, i);
            // for even
            String evenLength = palindrome(s, i, i + 1);

            if (oddLength.length() > longest.length()) {
                longest = oddLength;
            }
            if (evenLength.length() > longest.length()) {
                longest = evenLength;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "babad";

        System.out.println(longestPalindrome(s));

    }
}
