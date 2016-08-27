/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * 
 * Example:
 * Given a = 1 and b = 2, return 3.
 */
package leetcode;

public class LeetCode371SumofTwoIntegers {

    public int getSum(int a, int b) {

        while (b != 0) {
            int c = a & b; // carry on
            a = a ^ b;
            b = c << 1;
        }

        return a;
    }
}
