/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 */
package leetcode;

import java.util.Stack;

public class LeetCode227BasicCalculatorII {

    public int calculate(String s) {

        char[] c = s.toCharArray();
        Stack<Integer> number = new Stack<>();
        int result = 0;

        char sign = '+';

        for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i])) {
                int curr = 0;
                while (i < c.length && Character.isDigit(c[i])) {
                    curr = curr * 10 + c[i] - '0';
                    i++;
                }
                i--;

                if (sign == '+') {
                    number.push(curr);
                } else if (sign == '-') {
                    number.push(-curr);
                } else if (sign == '*') {
                    curr = number.pop() * curr;
                    number.push(curr);
                } else if (sign == '/') {
                    if (curr == 0) {
                        number.push(0);
                    } else {
                        curr = number.pop() / curr;
                        number.push(curr);
                    }
                }
            } else if (c[i] == '+') {
                sign = '+';
            } else if (c[i] == '-') {
                sign = '-';
            } else if (c[i] == '*') {
                sign = '*';
            } else if (c[i] == '/') {
                sign = '/';
            }
        }

        while (!number.isEmpty()) {
            result = result + number.pop();
        }

        return result;
    }
}
