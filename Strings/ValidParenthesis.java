//Question : Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//Time Complexity : O(n)
//Space Complexity : O(n)
package Strings;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : s.toCharArray()) {

            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else {
                if (stack.isEmpty() ||
                        !((bracket == ')' && stack.peek() == '(') ||
                                (bracket == ']' && stack.peek() == '[') ||
                                (bracket == '}' && stack.peek() == '{'))) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "{([])}";
        String s2 = "{({}]";

        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
    }
}
