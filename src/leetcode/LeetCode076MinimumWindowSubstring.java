/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode076MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> hasFound = new HashMap<>();
        Map<Character, Integer> needToFind = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (needToFind.containsKey(c)) {
                needToFind.put(c, needToFind.get(c) + 1);
            } else {
                needToFind.put(c, 1);
            }
        }

        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = s.length() - 1;
        int count = 0;

        while (end < s.length()) {
            if (!needToFind.containsKey(s.charAt(end))) {
                end++;
                continue;
            }

            if (!hasFound.containsKey(s.charAt(end))) {
                hasFound.put(s.charAt(end), 1);
            } else {
                hasFound.put(s.charAt(end), hasFound.get(s.charAt(end)) + 1);
            }

            if (hasFound.get(s.charAt(end)) <= needToFind.get(s.charAt(end))) {
                count++;
            }

            if (count == t.length()) {
                while (!needToFind.containsKey(s.charAt(start))
                        || hasFound.get(s.charAt(start)) > needToFind.get(s.charAt(start))) {
                    if (hasFound.containsKey(s.charAt(start))) {
                        hasFound.put(s.charAt(start), hasFound.get(s.charAt(start)) - 1);
                    }
                    start++;
                }
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                    minEnd = end;
                }
            }
            end++;
        }

        if (minLen <= s.length()) {
            return s.substring(minStart, minEnd + 1);
        } else {
            return "";
        }
    }
}
