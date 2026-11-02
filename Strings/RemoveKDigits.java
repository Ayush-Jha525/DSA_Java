/*Question : Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.*/
//Time Complexity : O(n) 
//Space Complexity : O(n)
package Strings;

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

        while (k > 0) {
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
    }
}
