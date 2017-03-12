/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 * 
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode336PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == words) {
            return result;
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String prefix = words[i].substring(0, j);
                String suffix = words[i].substring(j);

                if (isPalindrome(prefix)) {
                    String suffixRev = new StringBuilder(suffix).reverse().toString();
                    if (map.containsKey(suffixRev) && map.get(suffixRev) != i) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(map.get(suffixRev));
                        pair.add(i);
                        result.add(pair);
                    }
                }
                if (isPalindrome(suffix)) {
                    String prefixRev = new StringBuilder(prefix).reverse().toString();
                    if (suffix.length() != 0 && map.containsKey(prefixRev) && map.get(prefixRev) != i) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(map.get(prefixRev));
                        result.add(pair);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

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
