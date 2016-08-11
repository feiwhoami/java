/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

package leetcode;

import java.util.HashMap;

public class LeetCode242ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (null == map.get(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.isEmpty()) {
                return false;
            }
            if (null == map.get(t.charAt(i))) {
                return false;
            }

            int count = map.get(t.charAt(i));

            if (1 == count) {
                map.remove(t.charAt(i));
            } else {
                map.put(t.charAt(i), count - 1);
            }
        }

        if (map.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
