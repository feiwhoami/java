/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 */
package leetcode;

public class LeetCode172FactorialTrailingZeroes {

    public int trailingZeroes(int n) {

        int result = 0;

        long div = 5;

        while (div <= n) {
            result = (int) (result + n / div);
            div = div * 5;
        }

        return result;
    }
}
