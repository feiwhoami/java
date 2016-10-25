/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return
 * 
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131PalindromePartitioning {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<List<String>>();
        if (null == s) {
            return result;
        }

        List<String> curr = new ArrayList<>();
        partitionHelper(s, 0, curr, result);

        return result;
    }

    private void partitionHelper(String s, int start, List<String> curr, List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<String>(curr));
            return;
        }

        int end = start;
        while (end < s.length()) {
            if (isPalindrome(s, start, end)) {
                curr.add(s.substring(start, end + 1));
                partitionHelper(s, end + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
            end++;
        }
        return;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start < 0 || end >= s.length()) {
            return false;
        }
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
