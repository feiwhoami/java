/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
package leetcode;

public class LeetCode009PalindromeNumber {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }

        int div = 1;
        while (x / div >= 10) {
            div = div * 10;
        }

        while (x >= 10) {

            if (x % 10 != x / div) {
                return false;
            }

            x = (x % div) / 10;
            div = div / 100;
        }

        if (x == 0) {
            return true;
        }
        if (x < div) {
            return false;
        }

        return true;
    }
}
