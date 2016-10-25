/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
package leetcode;

public class LeetCode132PalindromePartitioningII {

    public int minCut(String s) {

        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        int[] cut = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cut[i] = len - i;
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i) < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    cut[i] = Math.min(cut[i], cut[j + 1] + 1);
                }
            }
        }
        return cut[0] - 1;
    }
}
