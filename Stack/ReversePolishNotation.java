/* Question : You are given an array of strings tokens representing an arithmetic expression in Reverse Polish Notation (Postfix).
        Evaluate the expression and return the integer result.
        Valid operators are: + , - , * , /
        Division should truncate toward zero. */
// Time Complexity : O(n)
// Space Complexity : O(n)
package Stack;

import java.util.Stack;

public class ReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String str : tokens) {
            if (!(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))) {
                stack.push(Integer.parseInt(str));
                continue;
            }
            int operand1 = stack.pop();
            int operand2 = stack.pop();
            int result = 0;
            switch (str) {
                case "+":
                    result = operand2 + operand1;
                    break;
                case "-":
                    result = operand2 - operand1;
                    break;
                case "*":
                    result = operand2 * operand1;
                    break;
                case "/":
                    result = operand2 / operand1;
                    break;
            }
            stack.push(result);
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens1 = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(tokens1)); // Output : 9

        String[] tokens2 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println(evalRPN(tokens2)); // Output : 22

    }
}
