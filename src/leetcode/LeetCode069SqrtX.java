/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 */
package leetcode;

public class LeetCode069SqrtX {

    public int mySqrt(int x) {

        int minDiff = Integer.MAX_VALUE;
        int diff;
        int result = 0;

        for (int i = 1; i <= x; i++) {
            diff = x - i * i;
            if (diff < 0) {
                return result;
            }
            if (0 == diff) {
                return i;
            }
            if (diff < minDiff) {
                result = i;
                minDiff = diff;
            }
        }

        return result;
    }

    public int mySqrt2(int x) {
        long start = 1;
        long end = x;

        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end > x) {
            return (int) start;
        } else {
            return (int) end;
        }

    }
}
