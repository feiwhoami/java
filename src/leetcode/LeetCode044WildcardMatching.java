/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
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
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
package leetcode;

public class LeetCode044WildcardMatching {

    public boolean isMatch(String s, String p) {

        int i = 0;
        int j = 0;
        int star = -1;
        int mark = -1;

        while (i < s.length()) {
            
            if (j < p.length() && compare(s.charAt(i), p.charAt(j))) {
                i++;
                j++;
            } else (j < p.length() && p.charAt(j) == '*') {
                
            }
        }

        while (j < p.length()) {
            if (p.charAt(j) != '*') {
                return false;
            }
            j++;
        }

        return true;
    }

    private boolean compare(char c1, char c2) {

        return c1 == c2 || c2 == '?';
    }
}
