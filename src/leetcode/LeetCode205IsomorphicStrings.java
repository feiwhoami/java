/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note:
 * You may assume both s and t have the same length.
 */
package leetcode;

import java.util.HashMap;

public class LeetCode205IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        if (null == s && null == t) {
            return true;
        }

        if (null == s || null == t) {
            return false;
        }

        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        HashMap<Character, Character> mapStoT = new HashMap<>();
        HashMap<Character, Character> mapTtoS = new HashMap<>();

        for (int i = 0; i < ss.length; i++) {
            if (!mapStoT.containsKey(ss[i]) && !mapTtoS.containsKey(tt[i])) {
                mapStoT.put(ss[i], tt[i]);
                mapTtoS.put(tt[i], ss[i]);
                continue;
            }

            if (!mapStoT.containsKey(ss[i])) {
                if (mapTtoS.get(tt[i]) != ss[i]) {
                    return false;
                }
                mapStoT.put(ss[i], tt[i]);
            }

            if (!mapTtoS.containsKey(tt[i])) {
                if (mapStoT.get(ss[i]) != tt[i]) {
                    return false;
                }
                mapTtoS.put(tt[i], ss[i]);
            }

            if (mapStoT.get(ss[i]) != tt[i] || mapTtoS.get(tt[i]) != ss[i]) {
                return false;
            }
        }

        return true;
    }
}
