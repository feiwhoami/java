/**
 * Given an integer, write a function to determine if it is a power of three.
 */
package leetcode;

public class LeetCode326PowerofThree {

    public boolean isPowerOfThree(int n) {

        if (0 == n) {
            return false;
        }

        if (1 == n) {
            return true;
        }

        int first = n / 3;
        int second = (n - first) / 2;
        int third = n - first - second;

        if (first != second || second != third) {
            return false;
        }

        return isPowerOfThree(first);

    }
}
