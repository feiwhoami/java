/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 */
package leetcode;

public class LeetCode029DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        if (0 == divisor) {
            return Integer.MAX_VALUE;
        }

        if (1 == divisor) {
            return dividend;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long dividendLong = dividend;
        long divisorLong = divisor;

        boolean dividendPositive = dividendLong >= 0 ? true : false;
        boolean divisorPositive = divisorLong >= 0 ? true : false;

        boolean resultPositive = dividendPositive == divisorPositive;

        dividendLong = Math.abs(dividendLong);
        divisorLong = Math.abs(divisorLong);

        long result = 0;

        while (divisorLong <= dividendLong) {
            int shift = 0;
            while (dividendLong >= (divisorLong << shift)) {
                shift++;
            }
            dividendLong = dividendLong - (divisorLong << (shift - 1));
            result = result + (1 << (shift - 1));
        }

        return (int) (resultPositive ? result : 0 - result);
    }
}
