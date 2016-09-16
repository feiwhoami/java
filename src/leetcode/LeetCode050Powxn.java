/**
 * Implement pow(x, n).
 */
package leetcode;

public class LeetCode050Powxn {

    public double myPow(double x, int n) {

        if (0 == x) {
            return 0;
        }

        if (1 == x) {
            return 1;
        }

        if (0 == n) {
            return 1;
        }

        if (1 == n) {
            return x;
        }

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (x * myPow(x, Integer.MAX_VALUE));
            }
            return 1 / myPow(x, -n);
        }

        if (n % 2 == 0) {
            double half = myPow(x, n / 2);
            return half * half;
        } else {
            double half = myPow(x, n / 2);
            return half * half * x;
        }

    }
}
