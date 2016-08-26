/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
package leetcode;

import java.util.Stack;

public class LeetCode020ValidParentheses {

    public boolean isValid(String s) {

        if (null == s) {
            return true;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            }

            if (c == ')') {
                if (st.isEmpty() || st.pop() != '(') {
                    return false;
                }
            }

            if (c == ']') {
                if (st.isEmpty() || st.pop() != '[') {
                    return false;
                }
            }

            if (c == '}') {
                if (st.isEmpty() || st.pop() != '{') {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
