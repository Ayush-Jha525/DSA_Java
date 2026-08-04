/*Question : You are given a non-negative integer num represented as a string and an integer k.
            -> Remove exactly k digits from the number so that the new number is the smallest possible.
            -> Return the resulting number as a string.
            -> If the result has leading zeros, remove them.
            -> If all digits are removed, return "0".
 */
// Time Complexity : O(n)
// Space Complexity : O(n)
package Stack;

import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();

        for (char c : num.toCharArray()) {
            int currentNum = c - '0';
            while (k > 0 && !stack.isEmpty() && stack.peek() > currentNum) {
                stack.pop();
                k--;
            }
            stack.push(currentNum);
        }

        while (k != 0) {
            stack.pop();
            k--;
        }

        StringBuilder newNum = new StringBuilder();
        for (int n : stack) {
            if (newNum.length() == 0 && n == 0) {
                continue;
            }
            newNum.append(n);
        }

        return newNum.length() == 0 ? "0" : newNum.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));

        num = "10200";
        k = 1;
        System.out.println(removeKdigits(num, k));

        num = "10";
        k = 2;
        System.out.println(removeKdigits(num, k));

        num = "12345";
        k = 2;
        System.out.println(removeKdigits(num, k));

    }
}
