/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * return 0.
 * 
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
package leetcode;

import java.util.HashMap;

public class LeetCode387FirstUniqueCharacterinaString {

    public int firstUniqChar(String s) {

        if (null == s) {
            return -1;
        }

        char[] c = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < c.length; i++) {
            if (null == map.get(c[i])) {
                map.put(c[i], 1);
            } else {
                map.put(c[i], map.get(c[i]) + 1);
            }
        }

        for (int i = 0; i < c.length; i++) {
            if (1 == map.get(c[i])) {
                return i;
            }
        }

        return -1;
    }
}
