/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode301RemoveInvalidParentheses {

    private int max = 0;

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        String curr = "";

        removeInvalidParenthesesHelper(curr, 0, 0, s, result);
        return result;
    }

    private void removeInvalidParenthesesHelper(String curr, int left, int right, String remain, List<String> result) {
        if (remain.isEmpty()) {
            if (left == right && left >= max && !result.contains(curr)) {
                max = left;
                result.add(new String(curr));
            }
            return;
        }

        char next = remain.charAt(0);

        if (next == '(') {
            String nextStr = curr + next;
            removeInvalidParenthesesHelper(nextStr, left + 1, right, remain.substring(1), result);

            removeInvalidParenthesesHelper(curr, left, right, remain.substring(1), result);
        } else if (next == ')') {
            if (left > right) {
                String nextStr = curr + next;
                removeInvalidParenthesesHelper(nextStr, left, right + 1, remain.substring(1), result);
            }

            removeInvalidParenthesesHelper(curr, left, right, remain.substring(1), result);
        } else {
            String nextStr = curr + next;
            removeInvalidParenthesesHelper(nextStr, left, right, remain.substring(1), result);
        }
    }
}
