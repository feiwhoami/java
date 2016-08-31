/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.
 * 
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
package leetcode;

public class LeetCode357CountNumberswithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {

        if (n < 0 || n > 10) {
            return 0;
        }

        if (0 == n) {
            return 1;
        }

        int result = 1;

        for (int i = 1; i < n; i++) {
            result = result * (10 - i);
        }

        result = result * 9 + countNumbersWithUniqueDigits(n - 1);

        return result;
    }
}
