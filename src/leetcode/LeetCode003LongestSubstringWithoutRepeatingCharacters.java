/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
package leetcode;

import java.util.HashMap;

public class LeetCode003LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        if (null == s || s.isEmpty()) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0, end = 0;

        while (end < s.length() && !map.containsKey(s.charAt(end))) {
            map.put(s.charAt(end), end);
            end++;
        }

        int maxLength = end - start;

        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                maxLength = Math.max(maxLength, end - start);

                int i = start;
                while (i < map.get(s.charAt(end))) {
                    map.remove(s.charAt(i));
                    i++;
                }

                start = map.get(s.charAt(end)) + 1;
            }
            map.put(s.charAt(end), end);
            end++;
        }

        return Math.max(maxLength, end - start);
    }
}
