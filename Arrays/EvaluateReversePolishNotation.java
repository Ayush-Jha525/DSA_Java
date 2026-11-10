/*Question : ou are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
*/
//Time Complexity : O(n)
//Space Complexity : O(n) 
package Arrays;

import java.util.Stack;

public class EvaluateReversePolishNotation {
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
        String[] tokens = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(tokens)); // Output: 9

        tokens = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println(evalRPN(tokens)); // Output: 22
    }
}
