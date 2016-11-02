/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
package leetcode;

import java.util.Stack;

public class LeetCode150EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                int val = 0;
                if (tokens[i].equals("+")) {
                    val = first + second;
                } else if (tokens[i].equals("-")) {
                    val = first - second;
                } else if (tokens[i].equals("*")) {
                    val = first * second;
                } else if (tokens[i].equals("/")) {
                    val = first / second;
                }
                stack.push(val);
            } else {
                int val = Integer.valueOf(tokens[i]);
                stack.push(val);
            }
        }
        return stack.pop();
    }
}
