//Question: Given a string, determine whether it reads the same forwards and backwards. 
//  Return true if it is a palindrome; otherwise, return false.
//Time Complexity : O(n)
//Space Complexity : O(1)
package Strings;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        int n = str.length();
        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "racecar";

        System.out.println(isPalindrome(str));
    }
}
