/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * <p>
 * Given n, find the total number of full staircase rows that can be formed.
 * <p>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p>
 * Example 1:
 * <p>
 * n = 5
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 * <p>
 * n = 8
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 4th row is incomplete, we return 3.
 */
package leetcode;

public class LeetCode441ArrangingCoins {
    public int arrangeCoins(int n) {
        int result = 0;
        int k = 1;

        while (n >= k) {
            n = n - k;
            k++;
            result++;
        }

        return result;
    }

}
