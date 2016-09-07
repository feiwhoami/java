/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode022GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        String curr = "";
        generateParenthesisHelper(n, n, curr, result);

        return result;
    }

    private void generateParenthesisHelper(int left, int right, String curr, List<String> result) {
        if (0 == left && 0 == right) {
            result.add(curr);
            return;
        }
        if (left > 0) {
            curr = curr + '(';
            generateParenthesisHelper(left - 1, right, curr, result);
            curr = curr.substring(0, curr.length() - 1);
        }
        if (left < right) {
            curr = curr + ')';
            generateParenthesisHelper(left, right - 1, curr, result);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}
