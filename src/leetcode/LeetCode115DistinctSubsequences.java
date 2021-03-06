/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * 
 * Return 3.
 */
package leetcode;

public class LeetCode115DistinctSubsequences {

    public int numDistinct(String s, String t) {

        if (null == s || null == t) {
            return 0;
        }

        int[][] dp = new int[t.length() + 1][s.length() + 1];

        for (int i = 0; i <= t.length(); i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j <= s.length(); j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= t.length(); i++) {
            for (int j = i; j <= s.length(); j++) {

                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[t.length()][s.length()];

    }

}
