//Question : A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. 
//  Alphanumeric characters include letters and numbers.

//Time Complexity : O(n)
//Space Complexity : O(1)
package Strings;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int front = 0;
        int end = s.length() - 1;

        while (front < end) {
            char frontChar = Character.toLowerCase(s.charAt(front));
            char endChar = Character.toLowerCase(s.charAt(end));
            if (Character.isLetterOrDigit(frontChar) && Character.isLetterOrDigit(endChar)) {
                if (frontChar != endChar) {
                    return false;
                } else {
                    front++;
                    end--;
                }
            } else if (Character.isLetterOrDigit(frontChar)) {
                end--;
            } else {
                front++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
