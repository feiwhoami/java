/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * 
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
package leetcode;

import java.util.HashMap;

public class LeetCode290WordPattern {

    public boolean wordPattern(String pattern, String str) {

        if (null == pattern || null == str) {
            return false;
        }

        HashMap<Character, String> patternToStr = new HashMap<>();
        HashMap<String, Character> strToPattern = new HashMap<>();

        String[] words = str.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (null == patternToStr.get(pattern.charAt(i)) && null == strToPattern.get(words[i])) {
                patternToStr.put(pattern.charAt(i), words[i]);
                strToPattern.put(words[i], pattern.charAt(i));
            }

            if (null == patternToStr.get(pattern.charAt(i)) || null == strToPattern.get(words[i])) {
                return false;
            }

            if (!patternToStr.get(pattern.charAt(i)).equalsIgnoreCase(words[i])
                    || strToPattern.get(words[i]) != pattern.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
