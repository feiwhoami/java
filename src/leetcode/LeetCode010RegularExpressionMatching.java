/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
package leetcode;

public class LeetCode010RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        if (s.isEmpty()) {
            return checkEmpty(p);
        }

        if (p.isEmpty()) {
            return false;
        }

        char s1 = s.charAt(0);
        char p1 = p.charAt(0);
        char p2 = ' ';

        if (p.length() > 1) {
            p2 = p.charAt(1);
        }

        if (p2 == '*') {
            if (compare(s1, p1)) {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            if (compare(s1, p1)) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }

    private boolean compare(char s1, char p1) {

        return p1 == '.' || s1 == p1;
    }

    private boolean checkEmpty(String p) {

        if (p.length() % 2 != 0) {
            return false;
        }

        for (int i = 1; i < p.length(); i = i + 2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }

        return true;
    }
}
