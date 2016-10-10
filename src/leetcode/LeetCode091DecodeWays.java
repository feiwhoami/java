/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 */
package leetcode;

public class LeetCode091DecodeWays {

    public int numDecodings(String s) {

        if (null == s || s.isEmpty()) {
            return 0;
        }

        char[] c = s.toCharArray();
        int[] dp = new int[c.length + 1];

        if (Character.getNumericValue(c[0]) > 9 || Character.getNumericValue(c[0]) < 1) {
            return 0;
        }
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < c.length; i++) {

            int tmp = Character.getNumericValue(c[i - 1]) * 10 + Character.getNumericValue(c[i]);

            if (tmp >= 10 && tmp <= 26) {
                dp[i + 1] = dp[i + 1] + dp[i - 1];
            }

            if (c[i] != '0') {
                dp[i + 1] = dp[i + 1] + dp[i];
            }

            if (dp[i + 1] == 0) {
                return 0;
            }

        }

        return dp[c.length];
    }
}
