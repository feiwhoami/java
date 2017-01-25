/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 */
package leetcode;

import java.util.Stack;

public class LeetCode224BasicCalculator {

    public int calculate(String s) {

        char[] c = s.toCharArray();
        Stack<Integer> number = new Stack<>();

        int result = 0;
        int sign = 1;

        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                int curr = 0;
                while (i < c.length && Character.isDigit(c[i])) {
                    curr = curr * 10 + c[i] - '0';
                    i++;
                }
                i--;
                result = result + curr * sign;
            } else if (c[i] == '+') {
                sign = 1;
            } else if (c[i] == '-') {
                sign = -1;
            } else if (c[i] == '(') {
                number.push(result);
                number.push(sign);
                result = 0;
                sign = 1;
            } else if (c[i] == ')') {
                result = result * number.pop() + number.pop();
                sign = 1;
            }
        }

        return result;
    }
}
