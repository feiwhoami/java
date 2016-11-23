/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 */
package leetcode;

public class LeetCode214ShortestPalindrome {

    public String shortestPalindrome(String s) {

        String result = new String();
        if (null == s || s.length() == 0) {
            return result;
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int right = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }

        for (int j = 0; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if ((i + 1 > j - 1 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = len - 1; i >= 0; i--) {
            if (dp[0][i]) {
                right = i;
                break;
            }
        }

        String prefix = reverseString(s.substring(right + 1, s.length()));
        return prefix + s;
    }

    private String reverseString(String s) {

        if (null == s || s.length() == 0) {
            return new String();
        }

        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;

        while (left < right) {
            char tmp = c[left];
            c[left] = c[right];
            c[right] = tmp;

            left++;
            right--;
        }

        return new String(c);
    }
}
