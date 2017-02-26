/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * 
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * 
 * Example 2:
 * Input: "aba"
 * Output: False
 * 
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */
package leetcode;

public class LeetCode459RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {

        int len = s.length();
        int subLen = 1;

        while (subLen <= len / 2) {
            if (len % subLen == 0) {
                int start = 0;
                String firstSubStr = s.substring(0, subLen);
                boolean result = true;
                while (start <= len - subLen) {
                    String subStr = s.substring(start, start + subLen);
                    if (!firstSubStr.equals(subStr)) {
                        result = false;
                        break;
                    }
                    start = start + subLen;
                }
                if (result) {
                    return result;
                }
            }
            subLen++;
        }
        return false;
    }
}
