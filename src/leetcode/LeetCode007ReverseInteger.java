/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
package leetcode;

public class LeetCode007ReverseInteger {

    public int reverse(int x) {

        if (0 == x) {
            return 0;
        }

        int positive;

        if (x > 0) {
            positive = 1;
        } else {
            positive = -1;
            x = -x;
        }

        long multiplier = 1;
        int tmp = x;

        long result = 0;

        while (tmp >= 10) {
            tmp = tmp / 10;
            multiplier = multiplier * 10;
        }

        while (x >= 10) {
            int digit = x % 10;
            result = result + digit * multiplier;
            multiplier = multiplier / 10;
            x = x / 10;
        }

        result = (result + x) * positive;

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) result;
    }
}
