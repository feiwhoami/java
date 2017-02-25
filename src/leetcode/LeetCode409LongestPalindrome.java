/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input:
 * "abccccdd"
 * 
 * Output:
 * 7
 * 
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode409LongestPalindrome {

    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                result = result + 2;
                set.remove(s.charAt(i));
            }
        }

        if (!set.isEmpty()) {
            result++;
        }

        return result;
    }

}
