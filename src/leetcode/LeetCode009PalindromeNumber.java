/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
package leetcode;

public class LeetCode009PalindromeNumber {

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int div = 1;
        while (x / div >= 10) {
            div = div * 10;
        }

        while (x != 0) {

            if (x % 10 != x / div) {
                return false;
            }

            x = (x % div) / 10;
            div = div / 100;
        }

        return true;
    }
}
