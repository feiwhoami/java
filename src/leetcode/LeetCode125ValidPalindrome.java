/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 */
package leetcode;

public class LeetCode125ValidPalindrome {

    public boolean isPalindrome(String s) {

        if (null == s || s.isEmpty()) {
            return true;
        }

        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j))) {
                j--;
            } else if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
