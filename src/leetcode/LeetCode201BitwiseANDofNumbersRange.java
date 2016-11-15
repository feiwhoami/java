/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 */
package leetcode;

public class LeetCode201BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {

        int d = Integer.MAX_VALUE;

        while ((m & d) != (n & d)) {
            d = d << 1;
        }

        return m & d;
    }

}
