/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
package leetcode;

public class LeetCode005LongestPalindromicSubstring {

    public String longestPalindrome(String s) {

        if (null == s) {
            return null;
        }

        int maxLen = Integer.MIN_VALUE;
        String result = "";

        for (int i = 0; i < s.length(); i++) {

            String sub1 = expand(s, i, i);
            String sub2 = expand(s, i, i + 1);

            if (sub1.length() > maxLen) {
                result = sub1;
                maxLen = result.length();
            }
            if (sub2.length() > maxLen) {
                result = sub2;
                maxLen = result.length();
            }
        }

        return result;
    }

    private String expand(String s, int centerL, int centerR) {

        int l = centerL, r = centerR;

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return s.substring(l + 1, r);
    }
}
