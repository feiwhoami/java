/**
 * Given an integer, write a function to determine if it is a power of two.
 */

package leetcode;

public class LeetCode231PowerofTwo {

    public boolean isPowerOfTwo(int n) {

        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        int half = n / 2;

        if (half != n - half) {
            return false;
        }

        return isPowerOfTwo(half);
    }
}
