/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * 
 * Example 1
 * Input: "2-1-1".
 * 
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * 
 * Example 2
 * Input: "2*3-4*5"
 * 
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode241DifferentWaystoAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        if (null == input || input.length() == 0) {
            return result;
        }

        for (int i = 0; i < input.length(); i++) {
            if (isOperator(input.charAt(i))) {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int a : left) {
                    for (int b : right) {
                        result.add(compute(a, b, input.charAt(i)));
                    }
                }
            }
        }

        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }

        return result;
    }

    private int compute(int a, int b, char c) {
        if (c == '+') {
            return a + b;
        } else if (c == '-') {
            return a - b;
        } else if (c == '*') {
            return a * b;
        }
        return 0;
    }

    private boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*') {
            return true;
        } else {
            return false;
        }
    }

}
