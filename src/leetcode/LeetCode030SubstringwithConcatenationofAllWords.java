/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * 
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode030SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        if (null == words || words.length == 0) {
            return result;
        }
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> exists = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                map.put(words[i], map.get(words[i]) + 1);
            }
        }

        int singleWordLength = words[0].length();
        int totalLength = words.length * singleWordLength;

        for (int i = 0; i <= s.length() - totalLength; i++) {

            int j = i;
            exists.clear();
            for (; j < i + totalLength; j = j + words[0].length()) {

                String subString = s.substring(j, j + singleWordLength);

                if (!map.containsKey(subString)) {
                    break;
                }

                if (!exists.containsKey(subString)) {
                    exists.put(subString, 1);
                } else {
                    exists.put(subString, exists.get(subString) + 1);
                }

                if (exists.get(subString) > map.get(subString)) {
                    break;
                }
            }
            if (j == i + totalLength) {
                result.add(i);
            }
        }

        return result;
    }
}
