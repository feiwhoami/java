/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
package leetcode;

import java.util.Stack;

public class LeetCode032LongestValidParentheses {

    public int longestValidParentheses(String s) {

        if (null == s || s.length() == 0) {
            return 0;
        }

        char[] c = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < c.length; i++) {
            if ('(' == c[i]) {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                c[i] = 'k';
                c[stack.pop()] = 'k';
            }
        }

        int maxLen = 0;
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            if ('k' == c[i]) {
                len++;
                maxLen = Math.max(len, maxLen);
            } else {
                len = 0;
            }
        }

        return maxLen;
    }
}
