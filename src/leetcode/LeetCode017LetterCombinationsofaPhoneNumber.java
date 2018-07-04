/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
package leetcode;

import java.util.*;

public class LeetCode017LetterCombinationsofaPhoneNumber {

    private Map<Character, List<Character>> phoneKeys = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        phoneKeys.put('0', null);
        phoneKeys.put('1', null);
        phoneKeys.put('2', Arrays.asList('a', 'b', 'c'));
        phoneKeys.put('3', Arrays.asList('d', 'e', 'f'));
        phoneKeys.put('4', Arrays.asList('g', 'h', 'i'));
        phoneKeys.put('5', Arrays.asList('j', 'k', 'l'));
        phoneKeys.put('6', Arrays.asList('m', 'n', 'o'));
        phoneKeys.put('7', Arrays.asList('p', 'q', 'r', 's'));
        phoneKeys.put('8', Arrays.asList('t', 'u', 'v'));
        phoneKeys.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> result = new ArrayList<>();
        if (null == digits || digits.isEmpty()) {
            return result;
        }
        String curr = "";
        letterCombinationsHelper(digits, 0, curr, result);

        return result;
    }

    private void letterCombinationsHelper(String digits, int index, String curr, List<String> result) {
        if (index > digits.length()) {
            return;
        }

        if (index == digits.length()) {
            result.add(curr);
            return;
        }

        char c = digits.charAt(index);

        List<Character> keys = phoneKeys.get(c);
        if (keys == null) {
            letterCombinationsHelper(digits, index + 1, curr, result);
        } else {
            for (Character k : keys) {
                curr = curr + k;
                letterCombinationsHelper(digits, index + 1, curr, result);
                curr = curr.substring(0, curr.length() - 1);
            }
        }
    }
}
