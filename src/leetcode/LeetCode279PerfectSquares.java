/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
package leetcode;

public class LeetCode279PerfectSquares {

    public int numSquares(int n) {

        int[] result = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            result[i] = i;
        }

        for (int i = 2; i < n + 1; i++) {
            int j = 1;
            while (i > j * j) {
                result[i] = Math.min(result[i], 1 + result[i - j * j]);
                j++;
            }

            if (i == j * j) {
                result[i] = 1;
            }
        }

        return result[n];
    }
}
