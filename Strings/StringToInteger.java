/*Question : Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.

Note:​​​​​​​ You must not use any built-in library function that converts a string to a number (for example, atoi, stoi, Integer.parseInt, int(), parseInt, Number()). Perform the conversion manually. */
//Time Complexity : O(n);    
//Space Complexity : O(1);

package Strings;

public class StringToInteger {
    public static int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        long num = 0;
        int i = 0;
        boolean isNegative = false;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) {
            return 0;
        }

        if (s.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i++) - '0');

            if (num > Integer.MAX_VALUE) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }

        if (isNegative) {
            num *= -1;
        }
        return (int) num;
    }

    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(myAtoi(s));

        s = "words and 987";
        System.out.println(myAtoi(s));

        s = "0-1";
        System.out.println(myAtoi(s));

        s = "   -042";
        System.out.println(myAtoi(s));
    }
}
