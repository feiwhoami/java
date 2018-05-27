/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode438FindAllAnagramsinaString {
    public List <Integer> findAnagrams(String s, String p) {
        List <Integer> result = new ArrayList <>();

        if (s == null || s.isEmpty() || p == null || p.isEmpty()) {
            return result;
        }
        if (s.length() < p.length()) {
            return result;
        }

        Map <Character, Integer> pLib = new HashMap <>();
        for (int i = 0; i < p.length(); i++) {
            if (!pLib.containsKey(p.charAt(i))) {
                pLib.put(p.charAt(i), 1);
            } else {
                pLib.put(p.charAt(i), pLib.get(p.charAt(i)) + 1);
            }
        }

        Map <Character, Integer> sLib = new HashMap <>();
        for (int i = 0; i < p.length(); i++) {
            if (!sLib.containsKey(s.charAt(i))) {
                sLib.put(s.charAt(i), 1);
            } else {
                sLib.put(s.charAt(i), sLib.get(s.charAt(i)) + 1);
            }
        }

        int index = 0;
        for (; index + p.length() <= s.length(); index++) {
            if (sLib.equals(pLib)) {
                result.add(index);
            }
            if (index + p.length() >= s.length()) {
                continue;
            }

            if (sLib.get(s.charAt(index)) == 1) {
                sLib.remove(s.charAt(index));
            } else {
                sLib.put(s.charAt(index), sLib.get(s.charAt(index)) - 1);
            }

            if (!sLib.containsKey(s.charAt(index + p.length()))) {
                sLib.put(s.charAt(index + p.length()), 1);
            } else {
                sLib.put(s.charAt(index + p.length()), sLib.get(s.charAt(index + p.length())) + 1);
            }
        }

        return result;
    }
}
