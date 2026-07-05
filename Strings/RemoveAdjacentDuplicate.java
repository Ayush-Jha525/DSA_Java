//Question : Remove all adjacent duplicate characters from the string and find the resultant string. The order of remaining characters in the output should be same as in the original string.
//Time Complexity : O(n)
//Space Complexity : O(n)
package Strings;

import java.util.Stack;

public class RemoveAdjacentDuplicate {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (stack.isEmpty() || stack.peek() != current) {
                stack.push(current);
            } else {
                stack.pop();
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";

        System.out.println(removeDuplicates(s));
    }
}
