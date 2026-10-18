/*Question : Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
    You must solve the problem without using any built-in library for handling large integers (such as BigInteger). 
    You must also not convert the inputs to integers directly. */
//Time Complexity : O(max(n,m))      n: num1.size, m: num2.size
//Space Complexity : O(max(n,m))
package Strings;

public class AddStrings {
    public static String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0) {
            int number1 = ((i >= 0) ? num1.charAt(i--) : '0') - '0';
            int number2 = ((j >= 0) ? num2.charAt(j--) : '0') - '0';

            int sum = number1 + number2 + carry;

            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "1624";
        String num2 = "276";

        System.out.println(addStrings(num1, num2));
    }
}
