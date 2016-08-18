/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * 
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 */
package leetcode;

public class LeetCode342PowerofFour {

    public boolean isPowerOfFour(int num) {

        if (0 == num) {
            return false;
        }

        if (1 == num) {
            return true;
        }

        int half = num / 2;
        if (half != num - half) {
            return false;
        }

        int quater = half / 2;
        if (quater != half - quater) {
            return false;
        }

        return isPowerOfFour(quater);
    }
}
